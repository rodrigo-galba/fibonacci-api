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
    void setup() {
        service = new FibonacciService();
    }

    @Test
    void testCalculate() {
        assertThat(1L, equalTo(service.calculate(1L)));
        assertThat(1L, equalTo(service.calculate(2L)));
        assertThat(2L, equalTo(service.calculate(3L)));
        assertThat(3L, equalTo(service.calculate(4L)));
        assertThat(5L, equalTo(service.calculate(5L)));
        assertThat(8L, equalTo(service.calculate(6L)));
    }

    @Test
    void testCalculateWhenZero() {
        Long result = service.calculate(0L);
        Long expected = 0L;
        assertThat(expected, equalTo(result));
    }

    @Test
    void testCalculateWhenNull() {
        Long result = service.calculate(null);
        Long expected = 0L;
        assertThat(expected, equalTo(result));
    }

    @Test
    void testCalculateSeries() {
        assertThat(List.of(1L), equalTo(service.calculateSeries(1L)));
        assertThat(List.of(1L, 1L), equalTo(service.calculateSeries(2L)));
        assertThat(List.of(1L, 1L, 2L), equalTo(service.calculateSeries(3L)));
        assertThat(List.of(1L, 1L, 2L, 3L), equalTo(service.calculateSeries(4L)));
        assertThat(List.of(1L, 1L, 2L, 3L, 5L), equalTo(service.calculateSeries(5L)));
        assertThat(List.of(1L, 1L, 2L, 3L, 5L, 8L), equalTo(service.calculateSeries(6L)));
    }

    @Test
    void testCalculateSeriesWhenZero() {
        assertThat(List.of(), equalTo(service.calculateSeries(0L)));
    }

    @Test
    void testCalculateSeriesWhenNull() {
        assertThat(List.of(), equalTo(service.calculateSeries(null)));
    }
}