package br.com.kmpx.infrastructure.controller;

import br.com.kmpx.infrastructure.dto.request.CreateUserRequest;
import br.com.kmpx.infrastructure.dto.response.BaseResponse;
import br.com.kmpx.infrastructure.mapper.UserMapper;
import br.com.kmpx.usecase.CreateUserUseCase;
import br.com.kmpx.usecase.EmailAvailableUseCase;
import br.com.kmpx.usecase.TaxNumberAvaliableUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.kmpx.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    final private CreateUserUseCase createUserUseCase;
    final private UserMapper userMapper;
    final private EmailAvailableUseCase emailAvailableUseCase;
    final private TaxNumberAvaliableUseCase taxNumberAvaliableUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper, EmailAvailableUseCase emailAvailableUseCase, TaxNumberAvaliableUseCase taxNumberAvaliableUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.taxNumberAvaliableUseCase = taxNumberAvaliableUseCase;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        log.info("Starting create user::UserController");
        emailAvailableUseCase.emailAvailableEmail(request.email());
        taxNumberAvaliableUseCase.taxNumberAvaliable(request.taxNumber());
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("Create user with success::UserController");
        return BaseResponse.<String>builder().success(true).message("User created with success").build();
    }
}
