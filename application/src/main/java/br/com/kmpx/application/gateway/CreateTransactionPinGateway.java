package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
