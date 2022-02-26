package ru.kpfu.springcontrollers.services;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    public String getMessage() {
        return "Hello from service";
    }
}
