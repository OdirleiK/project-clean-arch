package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
