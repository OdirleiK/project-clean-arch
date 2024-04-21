package br.com.kmpx.infrastructure.mapper;

import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.infrastructure.entity.TransactionPinEntity;
import br.com.kmpx.infrastructure.entity.UserEntity;
import br.com.kmpx.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
               wallet.getBalance(),
               userEntity,
               transactionPinEntity,
               wallet.getCreatedAt(),
               wallet.getUpdatedAt()
        );
    }
}
