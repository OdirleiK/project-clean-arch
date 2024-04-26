package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(String taxNumber) throws Exception;
}
