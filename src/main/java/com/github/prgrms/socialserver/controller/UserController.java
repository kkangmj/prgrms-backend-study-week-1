package com.github.prgrms.socialserver.controller;

import com.github.prgrms.socialserver.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.prgrms.socialserver.controller.ApiResponse.OK;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<UserDto>> users() {
        return OK(
            userService.findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList())
        );
    }
}
