package com.tj.library_sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan(basePackages = {"com.tj.library_sys.controller"})
//@EnableJpaRepositories(basePackages={"com.tj.library_sys.repository"})
//@EntityScan(basePackages={"com.tj.library_sys.entity"})
@SpringBootApplication
public class LibrarySysApplication {

  public static void main(String[] args) {
    SpringApplication.run(LibrarySysApplication.class, args);
  }

}
