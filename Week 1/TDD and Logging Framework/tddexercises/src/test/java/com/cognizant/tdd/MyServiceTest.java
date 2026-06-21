package com.cognizant.tdd;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    void testVerifyInteraction() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    void testArgumentMatching() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataById(anyString()))
                .thenReturn("Matched Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchDataById("123");

        assertEquals("Matched Data", result);

        verify(mockApi).getDataById(anyString());
    }

    @Test
    void testMultipleReturns() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call");

        assertEquals("First Call", mockApi.getData());
        assertEquals("Second Call", mockApi.getData());
    }

    @Test
    void testInteractionOrder() {

        ExternalApi mockApi = mock(ExternalApi.class);

        mockApi.getData();
        mockApi.getDataById("101");

        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).getDataById("101");
    }
}