package ru.kpfu.itis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
@ComponentScan({"ru.kpfu.itis.service"})
@PropertySource("classpath:app.properties")
public class RootConfig {

  @Resource
  private Environment env;

}
