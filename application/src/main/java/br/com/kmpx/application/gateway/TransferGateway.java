package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
