package ru.kpfu.itis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @GetMapping("/")
    @ResponseBody
    public String indexAction() {
        System.out.println("Index action worked");
        return "Index action";
    }

    @GetMapping("/hello")
    @ResponseBody
    @Process
    public String helloAction() {
        return "Hello world";
    }
}
