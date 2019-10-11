package me.rogal.fibonacci.controller;

import me.rogal.fibonacci.service.FibonacciService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class FibonacciControllerTest {

    @Mock
    private FibonacciService service;

    @InjectMocks
    private FibonacciController controller;

    @Test
    void testCalculate() {
        Long number = 1L;
        when(service.calculateSeries(number)).thenReturn(List.of(number));

        ResponseEntity<List<Long>> response = controller.calculate(number);

        verify(service, only()).calculateSeries(number);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(List.of(number), response.getBody());
    }

    @Test
    void testNumberValidationOnCalculate() {
        ResponseEntity<List<Long>> response = controller.calculate(null);

        verify(service, never()).calculateSeries(any());
        assertTrue(response.getStatusCode().isError());
        assertNull(response.getBody());
    }
}