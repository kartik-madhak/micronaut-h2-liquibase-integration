package com.incubyte.user;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Post
    public User createUser(@Body User user) {
        return userService.createUser(user);
    }
}
