package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.CreateWalletGateway;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
