package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.TransactionPin;

public interface CreateTransactionPinUseCase {
    void create(TransactionPin transactionPin);
}
