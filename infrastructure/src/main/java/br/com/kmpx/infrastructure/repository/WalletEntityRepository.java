package br.com.kmpx.infrastructure.repository;

import br.com.kmpx.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {

    WalletEntity findByUserEntityTaxNumber(String taxNumber);
}
