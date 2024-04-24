package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
