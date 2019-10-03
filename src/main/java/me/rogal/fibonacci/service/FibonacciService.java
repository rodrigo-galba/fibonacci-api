package me.rogal.fibonacci.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Service
public class FibonacciService {

    public Long calculate(Long number) {
        if(number == null || number == 0)
            return 0L;
        if(number == 1)
            return 1L;

        return calculate(number - 1) + calculate(number - 2);
    }

    public List<Long> calculateSeries(Long number) {
        List<Long> result = new ArrayList();

        if (number == null ) return result;

        LongStream.range(0, number)
                .forEach(i -> result.add(calculate(i+1)));
        return result;
    }
}
