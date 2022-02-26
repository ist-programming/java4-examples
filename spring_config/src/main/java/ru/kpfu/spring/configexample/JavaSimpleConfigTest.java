package ru.kpfu.spring.configexample;

import java.util.Calendar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaSimpleConfigTest {

  public static void main(String[] args) {
    System.out.println("Java config context configuration test");
    
    ApplicationContext context
      = new AnnotationConfigApplicationContext(SimpleConfig.class);
    
    DateFormatter obj = (DateFormatter) context.getBean("dateFormatter");
    System.out.println( obj.getDateFormatted(Calendar.getInstance()) );
    
    obj.setPattern("EEE, MMM d, yyyy");
    System.out.println( obj.getDateFormatted(Calendar.getInstance()) );
  }
}
