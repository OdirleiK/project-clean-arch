package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.core.domain.User;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
