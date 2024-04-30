package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.TransferException;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {
    Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception;
}
