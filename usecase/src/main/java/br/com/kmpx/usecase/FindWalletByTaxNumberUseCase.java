package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber) throws NotFoundException;
}
