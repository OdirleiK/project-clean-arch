package br.com.kmpx.repository;

import br.com.kmpx.entity.TransactionPinEntity;
import br.com.kmpx.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
