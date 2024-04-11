package br.com.kmpx.usecase;

import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.exception.EmailException;
import br.com.kmpx.core.exception.TaxNumberException;
import br.com.kmpx.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException;
}
