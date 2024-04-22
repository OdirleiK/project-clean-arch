package br.com.kmpx.infrastructure.config;

import br.com.kmpx.application.gateway.CreateUserGateway;
import br.com.kmpx.application.gateway.EmailAvailableGateway;
import br.com.kmpx.application.gateway.TaxNumberAvaliableGateway;
import br.com.kmpx.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.kmpx.application.usecaseimpl.EmailAvailableUseCaseImpl;
import br.com.kmpx.application.usecaseimpl.TaxNumberAvaliableUseCaseImpl;
import br.com.kmpx.usecase.CreateUserUseCase;
import br.com.kmpx.usecase.EmailAvailableUseCase;
import br.com.kmpx.usecase.TaxNumberAvaliableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvaliableUseCase taxNumberAvaliableUseCase(TaxNumberAvaliableGateway taxNumberAvaliableGateway) {
        return new TaxNumberAvaliableUseCaseImpl(taxNumberAvaliableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }
    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvaliableUseCase taxNumberAvaliableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl( taxNumberAvaliableUseCase,  emailAvailableUseCase,  createUserGateway);
    }
}
