package com.incubyte.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceShould {

    @Mock
    UserRepository userRepository;

    @Test
    void should_call_repository_get_users() {
        UserService userService = new UserService(userRepository);
        userService.getUsers();
        verify(userRepository).findAll();
    }

}
