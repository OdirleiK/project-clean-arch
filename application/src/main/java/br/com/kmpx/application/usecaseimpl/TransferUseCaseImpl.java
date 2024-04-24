package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.TransferGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.*;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;
import br.com.kmpx.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private TransferGateway transferGateway;
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(TransferGateway transferGateway, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.transferGateway = transferGateway;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws Exception {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveTransfer(value);

        Transaction transaction = createTransactionUseCase.create(new Transaction(from, to, value));
        transactionValidateUseCase.validate(transaction);

        if(!transferGateway.transfer(transaction))
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmail()))
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());

        return true;
    }
}
