package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.TransactionPinValidateGateway;
import br.com.kmpx.core.domain.TransactionPin;
import br.com.kmpx.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public boolean validate(TransactionPin transactionPin, String pin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if(transactionPinSaved.isEmpty())
            return false;

        if(transactionPinSaved.get().getPin() != transactionPin.getPin())
            return false;

        return true;
    }
}
