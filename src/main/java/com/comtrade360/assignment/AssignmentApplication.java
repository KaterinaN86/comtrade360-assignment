package com.comtrade360.assignment;

import com.comtrade360.assignment.data.Translation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class AssignmentApplication {


	public static void main(String[] args) {

		SpringApplication.run(AssignmentApplication.class, args);

	}

}
