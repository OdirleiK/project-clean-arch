package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.domain.TransactionPin;

public interface UpdateTransactionPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}
