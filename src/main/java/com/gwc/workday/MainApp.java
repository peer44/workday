package com.gwc.workday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {
    SpringApplication.run(MainApp.class, args);
  }
}
