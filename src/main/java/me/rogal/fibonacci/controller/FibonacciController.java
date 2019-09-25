package me.rogal.fibonacci.controller;

import lombok.RequiredArgsConstructor;
import me.rogal.fibonacci.service.FibonacciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FibonacciController {

    private final FibonacciService service;

    @GetMapping("/")
    public String index() {
        return "OK";
    }

    @PostMapping(value = "/{number}")
    public ResponseEntity<List<Long>> calculate(@PathVariable Long number) {
        if(number == null) {
            return ResponseEntity.notFound().build();
        }

        List<Long> result = service.calculateSeries(number);
        return ResponseEntity.ok().body(result);
    }
}
// 45 - 20s
// 42 -
// 41 - 3s
// 40 - 2s