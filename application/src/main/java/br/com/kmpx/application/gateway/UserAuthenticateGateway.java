package br.com.kmpx.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
