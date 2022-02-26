package ru.kpfu.spring.configexample;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatter {

  private String pattern = "d.MM.yyyy";

  public DateFormatter() {
  }

  public DateFormatter(String pattern) {
    this.pattern = pattern;
  }

  public String getDateFormatted(Calendar date) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date.getTime());
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

}
