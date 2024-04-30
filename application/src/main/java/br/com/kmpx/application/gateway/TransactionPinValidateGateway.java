package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    boolean validate(TransactionPin transactionPin, String pin);
}
