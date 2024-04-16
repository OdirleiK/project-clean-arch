package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
