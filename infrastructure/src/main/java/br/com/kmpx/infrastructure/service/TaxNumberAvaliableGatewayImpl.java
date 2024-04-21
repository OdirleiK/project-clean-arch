package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.TaxNumberAvaliableGateway;
import br.com.kmpx.infrastructure.repository.UserEntityRepository;
import static br.com.kmpx.infrastructure.utils.Utilities.log;

public class TaxNumberAvaliableGatewayImpl implements TaxNumberAvaliableGateway {

    private UserEntityRepository userEntityRepository;

    public TaxNumberAvaliableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvaliable(String taxNumber) {
        log.info("Start of verification taxNumber available");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
