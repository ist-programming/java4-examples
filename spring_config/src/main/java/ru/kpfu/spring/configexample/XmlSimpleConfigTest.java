package ru.kpfu.spring.configexample;

import java.util.Calendar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class XmlSimpleConfigTest {

  public static void main(String[] args) {
    new XmlSimpleConfigTest();
  }
  
  public XmlSimpleConfigTest(){
    System.out.println("XML config context configuration test");
    
    ApplicationContext context = 
             new FileSystemXmlApplicationContext(getClass().getResource("/itisSimpleConfig.xml").toString());
    
    DateFormatter obj = (DateFormatter) context.getBean("dateFormatter");
    System.out.println( obj.getDateFormatted(Calendar.getInstance()) );
    
    obj.setPattern("EEE, MMM d, yyyy");
    System.out.println( obj.getDateFormatted(Calendar.getInstance()) );
  }
}
