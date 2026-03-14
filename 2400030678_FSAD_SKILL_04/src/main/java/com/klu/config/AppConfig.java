package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.model.Student;

@Configuration

public class AppConfig {

    @Bean
    public Student student() {

        Student s = new Student(102,"Rahul");
        s.setCourse("Spring Framework");
        s.setYear("3rd Year");

        return s;
    }
}