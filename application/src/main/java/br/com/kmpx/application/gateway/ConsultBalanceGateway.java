package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
