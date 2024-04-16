package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.TransactionPin;
import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet);
}
