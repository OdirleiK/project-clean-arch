package br.com.kmpx.infrastructure.config;

import br.com.kmpx.application.gateway.*;
import br.com.kmpx.application.usecaseimpl.*;
import br.com.kmpx.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }

    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public TransactionValidateUseCase transactionValidateUseCase(TransactionValidateGateway transactionValidateGateway) {
        return new TransactionValidateUseCaseImpl(transactionValidateGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }

    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationUseCaseImpl(userNotificationGateway);
    }

    @Bean
    public TransactionPinValidateUseCase transactionPinValidateUseCase(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        return new TransactionPinValidateUseCaseImpl(transactionPinValidateGateway, updateTransactionPinUseCase);
    }

    @Bean
    public TransferUseCase transferUseCase(TransferGateway transferGateway) {
        return new TransferUseCaseImpl(transferGateway);
    }
}
