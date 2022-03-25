package ru.kpfu.itis.site;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.framework.Controller;

@Configuration
public class MainConfig {
    @Bean
    public Controller newsController(){
        return new NewsController();
    }
}
