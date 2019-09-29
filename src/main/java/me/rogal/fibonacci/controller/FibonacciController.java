package me.rogal.fibonacci.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.rogal.fibonacci.service.FibonacciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FibonacciController {

    private final FibonacciService service;

    @PostMapping(value = "/{number}")
    public ResponseEntity<List<Long>> calculate(@PathVariable Long number) {
        log.info("Processing number {}", number);
        if(number == null) {
            return ResponseEntity.notFound().build();
        }

        List<Long> result = service.calculateSeries(number);
        return ResponseEntity.ok().body(result);
    }
}