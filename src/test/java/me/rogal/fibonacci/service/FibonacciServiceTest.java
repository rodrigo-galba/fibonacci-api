package me.rogal.fibonacci.service;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciServiceTest {

    private FibonacciService service;

    @Test
    public void testCalculate() {
        service = new FibonacciService();
        Long result = service.calculate(1);
        Long expected = 1L;
        assertThat(expected, equalTo(result));
    }
}