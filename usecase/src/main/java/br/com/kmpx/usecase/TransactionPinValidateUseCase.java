package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.TransactionPin;
import br.com.kmpx.core.exception.PinException;
import br.com.kmpx.core.exception.TransferException;

public interface TransactionPinValidateUseCase {

    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
