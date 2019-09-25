package me.rogal.fibonacci.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    public long calculate(Integer number) {
        if(number == 0)
            return 0;
        else if(number == 1)
            return 1;
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
