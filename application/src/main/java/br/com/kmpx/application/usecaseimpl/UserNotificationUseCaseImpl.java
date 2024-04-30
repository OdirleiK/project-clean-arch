package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.UserNotificationGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    final private UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
