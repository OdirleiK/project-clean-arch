package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
