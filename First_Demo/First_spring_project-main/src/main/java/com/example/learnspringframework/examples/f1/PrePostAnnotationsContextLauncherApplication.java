package com.example.learnspringframework.examples.f1;

import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some Dependency is ready");
    }

    public void isDone() {
        System.out.println("Some Dependency is done");
    }

}

@Component
class SomeClass {

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies have been injected");
    }

    // Executes as soon as all the dependencies are injected
    // Sort of a constructor?
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    // Executes before destroying application, or,
    // going out of scope?
    // A destructor?
    @PreDestroy
    public void cleanup() {
        someDependency.isDone();
    }

}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}
