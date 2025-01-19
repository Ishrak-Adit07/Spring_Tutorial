package com.example.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        // 1. Launch a Spring Context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2. Configure what we want Spring to manage
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            // 3. Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("personMethodCall"));
            System.out.println(context.getBean("personParameters"));

            System.out.println(context.getBean("customAddress"));

            System.out.println(context.getBean(Person.class));

//        System.out.println("Bean names:");
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//        System.out.println("Bean count: " + context.getBeanDefinitionCount());

        }
    }

}
