package com.cognizant.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {

    @Test
    void testException() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(RuntimeException.class, () -> {
            thrower.throwException();
        });
    }
}