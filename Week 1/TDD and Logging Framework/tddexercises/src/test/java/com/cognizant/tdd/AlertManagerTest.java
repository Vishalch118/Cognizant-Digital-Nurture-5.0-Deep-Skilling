package com.cognizant.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AlertManagerTest {

    @Test
    void testVoidMethod() {

        NotificationService mockService = mock(NotificationService.class);

        doNothing().when(mockService)
                .sendNotification(anyString());

        AlertManager manager = new AlertManager(mockService);

        manager.triggerAlert();

        verify(mockService)
                .sendNotification("Alert Triggered");
    }

    @Test
    void testVoidMethodThrowsException() {

        NotificationService mockService = mock(NotificationService.class);

        doThrow(new RuntimeException("Notification Failed"))
                .when(mockService)
                .sendNotification(anyString());

        AlertManager manager = new AlertManager(mockService);

        assertThrows(RuntimeException.class,
                manager::triggerAlert);

        verify(mockService)
                .sendNotification("Alert Triggered");
    }
}