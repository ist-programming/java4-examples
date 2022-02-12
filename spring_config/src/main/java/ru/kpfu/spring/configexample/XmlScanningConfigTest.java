package ru.kpfu.spring.configexample;

import java.util.Calendar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * Code for studying purposes. Programming course, 4th semestr.
 * Kazan Federal University, ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */

public class XmlScanningConfigTest {

  public static void main(String[] args) {
    new XmlScanningConfigTest();
  }
  
  public XmlScanningConfigTest(){
    System.out.println("Scanning context configuration test");
    
    ApplicationContext context
      = new FileSystemXmlApplicationContext(getClass().getResource("/itisScanningConfig.xml").toString());
    
    DateFormatter obj = (DateFormatter) context.getBean("dateFormatter");
    System.out.println( obj.getDateFormatted(Calendar.getInstance()) );
    
    obj.setPattern("EEE, MMM d, yyyy");
    System.out.println( obj.getDateFormatted(Calendar.getInstance()) );
  }

}
