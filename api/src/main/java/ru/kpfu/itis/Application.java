package ru.kpfu.itis;

import ru.kpfu.itis.config.RootConfig;
import ru.kpfu.itis.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Main application class that starts Spring.
 * It's configuration class. However, all beans
 * and specific annotations are moved to another configurations.
 */
//@SpringBootApplication //We don't need this due to more control of app.
@Configuration
@EnableAutoConfiguration
@Import({RootConfig.class, WebConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

}
