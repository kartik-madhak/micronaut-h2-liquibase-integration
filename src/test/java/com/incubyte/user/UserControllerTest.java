package com.incubyte.user;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
class UserControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void should_get_users() {
        HttpRequest<Object> getUsersRequest = HttpRequest.GET("/users");
        //noinspection rawtypes
        List<Map> users = client.toBlocking().retrieve(getUsersRequest, Argument.listOf(Map.class));
        assertThat(users.size()).isZero();
//        System.out.println("users.get(0) = " + users.get(0));
    }

    @Test
    void should_create_user() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "someone");
        user.put("password", "password123");
        HttpRequest<Object> createUserRequest = HttpRequest.POST("/users", user);
        //noinspection rawtypes
        Map addedUser = client.toBlocking().retrieve(createUserRequest, Map.class);
        assertThat(addedUser.get("id")).isNotNull();
    }

}
