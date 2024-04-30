package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.TransferGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.*;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;
import br.com.kmpx.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private TransferGateway transferGateway;


    public TransferUseCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;

    }

    @Override
    public Boolean transfer(Transaction transaction) throws Exception {

        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());

        if(!transferGateway.transfer(transaction))
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());

        return true;
    }
}
