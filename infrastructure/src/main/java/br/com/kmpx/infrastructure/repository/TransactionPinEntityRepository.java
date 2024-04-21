package br.com.kmpx.infrastructure.repository;

import br.com.kmpx.infrastructure.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
