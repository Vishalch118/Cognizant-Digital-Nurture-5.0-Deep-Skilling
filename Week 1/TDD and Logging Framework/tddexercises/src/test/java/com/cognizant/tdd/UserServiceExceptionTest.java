package com.cognizant.tdd;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceExceptionTest {

    @Test
    void testUserNotFound() {

        UserRepository repository = mock(UserRepository.class);

        when(repository.findById(100L))
                .thenReturn(Optional.empty());

        UserService service = new UserService(repository);

        NoSuchElementException exception =
                assertThrows(
                        NoSuchElementException.class,
                        () -> service.getUserById(100L)
                );

        assertEquals("User not found", exception.getMessage());

        verify(repository).findById(100L);
    }
}