package me.rogal.fibonacci.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public class ErrorResponse {

    @Getter
    private String message;

    @Getter
    private List<String> details;
}
