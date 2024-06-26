package br.com.kmpx.infrastructure.mapper;

import br.com.kmpx.core.domain.TransactionPin;
import br.com.kmpx.infrastructure.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdatedAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionsPinEntity) {
        return new TransactionPin(
                transactionsPinEntity.getId(),
                transactionsPinEntity.getPin(),
                transactionsPinEntity.getAttempt(),
                transactionsPinEntity.getBlocked(),
                transactionsPinEntity.getCreatedAt(),
                transactionsPinEntity.getUpdatedAt()
        );
    }
}
