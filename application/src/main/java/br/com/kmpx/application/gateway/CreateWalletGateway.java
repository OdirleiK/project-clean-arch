package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Wallet;

public interface CreateWalletGateway {
    void create(Wallet wallet);
}
