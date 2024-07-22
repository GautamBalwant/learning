package com.example.practice.learning;

import com.example.practice.learning.di.TestDI;
import com.example.practice.learning.di.TestDIViaInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(LearningApplication.class, args);

	TestDI test = context.getBean(TestDI.class);
	test.testing();
	}

	@Bean
	public TestDIViaInjection getTestDIViaInjection (){
		return new TestDIViaInjection();
	}

}
