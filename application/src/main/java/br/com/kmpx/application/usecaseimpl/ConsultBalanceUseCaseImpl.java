package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.usecase.ConsultBalanceUseCase;
import br.com.kmpx.usecase.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    public ConsultBalanceUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        return findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber).getBalance();
    }
}
