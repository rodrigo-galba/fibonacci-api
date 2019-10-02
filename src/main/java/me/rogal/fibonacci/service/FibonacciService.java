package me.rogal.fibonacci.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    public Long calculate(Integer number) {
        if(number == null || number == 0)
            return 0L;
        else if(number == 1)
            return 1L;
        else
            return calculate(number - 1) + calculate(number - 2);
    }

    public List<Long> calculateSeries(Long number) {
        List<Long> result = new ArrayList();
        for (Integer i = 1; i <= number; i++) {
            result.add(calculate(i));
        }
        return result;
    }
}
