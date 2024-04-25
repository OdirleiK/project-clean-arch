package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction) throws Exception;
}
