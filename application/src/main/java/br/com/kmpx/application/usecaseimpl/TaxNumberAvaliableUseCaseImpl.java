package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.TaxNumberAvaliableGateway;
import br.com.kmpx.usecase.TaxNumberAvaliableUseCase;

public class TaxNumberAvaliableUseCaseImpl implements TaxNumberAvaliableUseCase {

    private TaxNumberAvaliableGateway taxNumberAvaliableGateway;

    public TaxNumberAvaliableUseCaseImpl(TaxNumberAvaliableGateway taxNumberAvaliableGateway) {
        this.taxNumberAvaliableGateway = taxNumberAvaliableGateway;
    }

    @Override
    public Boolean taxNumberAvaliable(String taxNumber) {
        return null;
    }
}
