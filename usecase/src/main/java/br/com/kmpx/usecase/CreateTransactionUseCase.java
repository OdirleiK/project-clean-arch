package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.exception.TransferException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction) throws TransferException;
}
