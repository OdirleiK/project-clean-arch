package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
