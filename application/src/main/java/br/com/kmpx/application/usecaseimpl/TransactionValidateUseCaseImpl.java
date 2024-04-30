package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.TransactionValidateGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.exception.TransferException;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;
import br.com.kmpx.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    final private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }


    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if(!transactionValidateGateway.validate(transaction))
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());

        return true;
    }
}
