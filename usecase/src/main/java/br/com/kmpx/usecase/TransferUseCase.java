package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction) throws Exception;
}
