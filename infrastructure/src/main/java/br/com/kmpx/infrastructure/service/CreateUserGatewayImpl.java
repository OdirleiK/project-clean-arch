package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.CreateUserGateway;
import br.com.kmpx.core.domain.User;
import br.com.kmpx.core.domain.Wallet;
import br.com.kmpx.infrastructure.mapper.TransactionPinMapper;
import br.com.kmpx.infrastructure.mapper.UserMapper;
import br.com.kmpx.infrastructure.mapper.WalletMapper;
import br.com.kmpx.infrastructure.repository.TransactionPinEntityRepository;
import br.com.kmpx.infrastructure.repository.UserEntityRepository;
import br.com.kmpx.infrastructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import static br.com.kmpx.infrastructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {

    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try{
            log.info("Start of user creation::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("User created with success::CreateUserGatewayImpl");
            return true;
        }catch (Exception e){
            log.info("Error in creation of user::CreateUserGatewayImpl");
            return false;
        }
    }
}
