package br.com.kmpx.usecase;

import br.com.kmpx.core.exception.TaxNumberException;

public interface TaxNumberAvaliableUseCase {
    Boolean taxNumberAvaliable(String taxNumber) throws TaxNumberException;
}
