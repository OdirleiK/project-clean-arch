package br.com.kmpx.infrastructure.service;

import br.com.kmpx.application.gateway.CreateTransactionGateway;
import br.com.kmpx.core.domain.Transaction;
import br.com.kmpx.infrastructure.mapper.TransactionMapper;
import br.com.kmpx.infrastructure.repository.TransactionEntityRepository;

public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) {
        try{
            var transactionEntity = transactionMapper.createTransaction(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            return null;
        }
    }
}
