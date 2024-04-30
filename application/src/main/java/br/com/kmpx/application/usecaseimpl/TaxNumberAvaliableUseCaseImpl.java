package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.TaxNumberAvaliableGateway;
import br.com.kmpx.core.exception.TaxNumberException;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;
import br.com.kmpx.usecase.TaxNumberAvaliableUseCase;

public class TaxNumberAvaliableUseCaseImpl implements TaxNumberAvaliableUseCase {

    private TaxNumberAvaliableGateway taxNumberAvaliableGateway;

    public TaxNumberAvaliableUseCaseImpl(TaxNumberAvaliableGateway taxNumberAvaliableGateway) {
        this.taxNumberAvaliableGateway = taxNumberAvaliableGateway;
    }

    @Override
    public Boolean taxNumberAvaliable(String taxNumber) throws TaxNumberException {
        if(!taxNumberAvaliableGateway.taxNumberAvaliable(taxNumber))
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());

        return true;
    }
}
