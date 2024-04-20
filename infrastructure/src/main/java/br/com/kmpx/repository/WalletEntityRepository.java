package br.com.kmpx.repository;

import br.com.kmpx.entity.UserEntity;
import br.com.kmpx.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
