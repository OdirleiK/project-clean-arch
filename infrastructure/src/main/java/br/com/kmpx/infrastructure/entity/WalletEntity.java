package br.com.kmpx.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Wallets")
public class WalletEntity {


    @Column(name = "Id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "UserId")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "TransactionsPinId")
    private TransactionPinEntity transactionsPinEntity;

    @Column(name = "CreatedAt ", nullable = false)
    private LocalDateTime createdAt ;

    @Column(name = "UpdateAt ")
    private LocalDateTime updateAt ;

    public WalletEntity(BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionsPinEntity, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.balance = balance;
        this.userEntity = userEntity;
        this.transactionsPinEntity = transactionsPinEntity;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
