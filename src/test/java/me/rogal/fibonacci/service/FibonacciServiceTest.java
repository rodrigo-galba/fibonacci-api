package me.rogal.fibonacci.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void calculateSeries() {
        assertThat(List.of(1L), equalTo(service.calculateSeries(1L)));
        assertThat(List.of(1L, 1L), equalTo(service.calculateSeries(2L)));
        assertThat(List.of(1L, 1L, 2L), equalTo(service.calculateSeries(3L)));
        assertThat(List.of(1L, 1L, 2L, 3L), equalTo(service.calculateSeries(4L)));
        assertThat(List.of(1L, 1L, 2L, 3L, 5L), equalTo(service.calculateSeries(5L)));
        assertThat(List.of(1L, 1L, 2L, 3L, 5L, 8L), equalTo(service.calculateSeries(6L)));
    }
}