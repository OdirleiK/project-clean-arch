package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.TransactionValidateGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.infrastructure.client.ApiValidateService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private ApiValidateService apiValidateService;

    @Override
    public Boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        if(response == null)
            return false;

        return response.success();
    }
}
