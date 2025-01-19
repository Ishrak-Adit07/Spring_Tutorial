package com.example.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ishrak Adit";
    }

    @Bean
    public int age() {
        return 23;
    }

    @Bean
    @Primary // In case of multiple beans of same class
    // @Qualifier("personQualifier") // This can be used for autowiring
    public Person person() {
        var person = new Person("Ishrak Adit", 23, new Address("Main Street", "Utrecht"));
        return person;
    }

    @Bean
    public Person personMethodCall() {
        var person = new Person(name(), age(), address());
        return person;
    }

    @Bean
    public Person personParameters(String name, int age, Address customAddress) {
        var person = new Person(name, age, customAddress);
        return person;
    }

//    @Bean
//    public Person personQualifier(String name, int age, @Qualifier("addressQualifier")Address address) {
//        var person = new Person(name, age, address);
//        return person;
//    }

    @Bean(name = "customAddress")
    public Address address() {
        var address = new Address("Baker Street", "London");
        return address;
    }

//    @Bean
    // @Qualifier("addressQualifier") // This can be used for autowiring
//    public Address address2() {
//        var address = new Address("Baker Street", "London");
//        return address;
//    }

}