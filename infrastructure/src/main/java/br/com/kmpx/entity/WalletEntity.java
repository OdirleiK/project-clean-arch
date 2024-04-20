package br.com.kmpx.entity;

import br.com.kmpx.core.domain.User;
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
    private UserEntity transactionsPinEntity;


    @Column(name = "Pin", nullable = false)
    private String pin;

    @Column(name = "CreatedAt ", nullable = false)
    private LocalDateTime createdAt ;

    @Column(name = "UpdatedAt ", nullable = false)
    private LocalDateTime updatedAt ;
}
