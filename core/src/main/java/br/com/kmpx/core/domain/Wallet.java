package br.com.kmpx.core.domain;

import br.com.kmpx.core.domain.enums.UserTypeEnum;
import br.com.kmpx.core.exception.TransferException;
import br.com.kmpx.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {

    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value){
        this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER)
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());

        if(this.balance.compareTo(value) < 0)
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());

        this.balance.subtract(value);
    }

    public void receiveTransfer(BigDecimal value) {
        this.balance.add(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }
    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && transactionPin.equals(wallet.transactionPin) && balance.equals(wallet.balance) && user.equals(wallet.user) && createdAt.equals(wallet.createdAt) && Objects.equals(updatedAt, wallet.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionPin, balance, user, createdAt, updatedAt);
    }
}
