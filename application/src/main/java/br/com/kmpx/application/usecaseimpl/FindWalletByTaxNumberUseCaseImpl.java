package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.FindWalletByTaxNumberGateway;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.NotFoundException;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;
import br.com.kmpx.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        Wallet wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if(wallet == null)
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());

        return  wallet;
    }
}
