package br.com.kmpx.infrastructure.mapper;

import br.com.kmpx.core.domain.TaxNumber;
import br.com.kmpx.core.domain.User;
import br.com.kmpx.infrastructure.dto.request.CreateUserRequest;
import br.com.kmpx.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
                request.email(),
                request.password(),
                new TaxNumber(request.taxNumber()),
                request.fullName(),
                request.type()
        );
    }

    public User toUser(UserEntity userEntity) throws Exception {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                new TaxNumber(userEntity.getTaxNumber()),
                userEntity.getFullName(),
                userEntity.getType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }
}
