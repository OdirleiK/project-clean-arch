package br.com.kmpx.application.usecaseimpl;

import br.com.kmpx.application.gateway.CreateUserGateway;
import br.com.kmpx.core.domain.TransactionPin;
import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.core.exception.EmailException;
import br.com.kmpx.core.exception.InternalServerErrorException;
import br.com.kmpx.core.exception.TaxNumberException;
import br.com.kmpx.core.exception.TransactionPinException;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;
import br.com.kmpx.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    final private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException, InternalServerErrorException {
        if(!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user)))
            throw  new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());

    }
}
