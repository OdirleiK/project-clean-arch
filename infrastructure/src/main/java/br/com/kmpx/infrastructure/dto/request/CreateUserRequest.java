package br.com.kmpx.infrastructure.dto.request;

import br.com.kmpx.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserTypeEnum type, String pin) {
}
