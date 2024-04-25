package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.TransferGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.infrastructure.mapper.TransactionMapper;
import br.com.kmpx.infrastructure.mapper.WalletMapper;
import br.com.kmpx.infrastructure.repository.TransactionEntityRepository;
import br.com.kmpx.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferGatewayImpl implements TransferGateway {

    private WalletEntityRepository walletEntityRepository;
    private TransactionEntityRepository transactionEntityRepository;
    private WalletMapper walletMapper;
    private TransactionMapper transactionMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
         try {
             walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getFromWallet()));
             walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getToWallet()));

             transactionEntityRepository.save(transactionMapper.concludedTransaction(transaction));
             return true;
         }catch (Exception e) {
             transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
             return false;
         }
    }
}
