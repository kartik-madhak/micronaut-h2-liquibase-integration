package com.incubyte.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerShould {

    @Mock
    UserService userService;

    @Test
    void should_call_get_user() {
        UserController userController = new UserController(userService);
        when(userService.getUsers()).thenReturn(List.of(new User()));
        List<User> users = userController.getUsers();
        verify(userService).getUsers();
    }

}
