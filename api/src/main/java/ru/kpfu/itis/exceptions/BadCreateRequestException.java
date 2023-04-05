package ru.kpfu.itis.exceptions;

import org.springframework.validation.BindingResult;

public class BadCreateRequestException extends RuntimeException {
    private BindingResult result;
    public BadCreateRequestException(BindingResult result) {
        this.result = result;
    }

    public BindingResult getResult() {
        return result;
    }
}
