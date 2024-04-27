package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.UserNotificationGateway;
import br.com.kmpx.core.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    @Override
    public Boolean notificate(Transaction transaction, String email) {
        //TODO: implementar
        return true;
    }
}
