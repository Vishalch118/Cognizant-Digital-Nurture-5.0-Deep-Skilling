package com.cognizant.tdd;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testGetUserByIdFound() {

        UserRepository repository = mock(UserRepository.class);

        User user = new User(1L, "Vishal");

        when(repository.findById(1L))
                .thenReturn(Optional.of(user));

        UserService service = new UserService(repository);

        User result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals("Vishal", result.getName());

        verify(repository).findById(1L);
    }

    @Test
void testGetUserByIdNotFound() {

    UserRepository repository = mock(UserRepository.class);

    when(repository.findById(99L))
            .thenReturn(Optional.empty());

    UserService service = new UserService(repository);

    assertThrows(
            NoSuchElementException.class,
            () -> service.getUserById(99L)
    );

    verify(repository).findById(99L);
}
}