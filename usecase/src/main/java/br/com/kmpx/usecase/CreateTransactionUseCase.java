package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
