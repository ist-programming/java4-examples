package ru.kpfu.spring.configexample;

import org.springframework.context.annotation.*;

/**
 * 
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */

@Configuration
public class SimpleConfig {

   @Bean 
   public DateFormatter dateFormatter(){
      return new DateFormatter();
   }
}
