package me.rogal.fibonacci.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.rogal.fibonacci.service.FibonacciService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Slf4j
@Validated
public class FibonacciController {

    private final FibonacciService service;

    @GetMapping(value = "/calculate/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Long>> calculate(@PathVariable("number") Long number) {
        log.info("Processing number {}", number);
        if(number == null) {
            return ResponseEntity.notFound().build();
        }

        List<Long> result = service.calculateSeries(number);
        return ResponseEntity.ok().body(result);
    }
}