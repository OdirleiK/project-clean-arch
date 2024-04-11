package br.com.kmpx.application.gateway;

import br.com.kmpx.core.domain.User;

public interface CreateUserGateway {

    User create(User user);
}
