package br.com.kmpx.usecase;

import br.com.kmpx.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password) throws AuthenticateException;

}
