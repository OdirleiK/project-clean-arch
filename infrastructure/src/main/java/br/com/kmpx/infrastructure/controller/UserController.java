package br.com.kmpx.infrastructure.controller;

import br.com.kmpx.infrastructure.dto.request.CreateUserRequest;
import br.com.kmpx.infrastructure.dto.response.BaseResponse;
import br.com.kmpx.infrastructure.mapper.UserMapper;
import br.com.kmpx.usecase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.kmpx.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        log.info("Starting create user::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("Create user with success::UserController");
        return BaseResponse.<String>builder().success(true).message("User created with success").build();
    }
}
