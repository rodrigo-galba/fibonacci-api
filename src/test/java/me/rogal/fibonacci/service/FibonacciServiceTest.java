package me.rogal.fibonacci.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciServiceTest {

    private FibonacciService service;

    @BeforeEach
    public void setup() {
        service = new FibonacciService();
    }

    @Test
    public void testCalculate() {
        assertThat(1L, equalTo(service.calculate(1)));
        assertThat(1L, equalTo(service.calculate(2)));
        assertThat(2L, equalTo(service.calculate(3)));
        assertThat(3L, equalTo(service.calculate(4)));
        assertThat(5L, equalTo(service.calculate(5)));
        assertThat(8L, equalTo(service.calculate(6)));
    }

    @Test
    public void calculateWhenZero() {
        Long result = service.calculate(0);
        Long expected = 0L;
        assertThat(expected, equalTo(result));
    }

    @Test
    public void calculateWhenNull() {
        Long result = service.calculate(null);
        Long expected = 0L;
        assertThat(expected, equalTo(result));
    }
}