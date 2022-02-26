package ru.kpfu.spring.configexample;

import org.springframework.context.annotation.*;

@Configuration
public class SimpleConfig {

   @Bean 
   public DateFormatter dateFormatter(){
      return new DateFormatter();
   }
}
