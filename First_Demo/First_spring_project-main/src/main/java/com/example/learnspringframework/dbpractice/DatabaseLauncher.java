package com.example.learnspringframework.dbpractice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DatabaseLauncher {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DatabaseLauncher.class)) {

//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            var businessCalculationService = context.getBean(BusinessCalculationService.class);
            System.out.println(businessCalculationService.findMax());

        }

    }

}
