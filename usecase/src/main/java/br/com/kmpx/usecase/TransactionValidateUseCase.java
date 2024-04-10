package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
