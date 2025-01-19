package com.example.springboot.learnjpaandhibernate.course;

import com.example.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.example.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;
//
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(55, "Introduction to Harry Potter", "JKR"));
//        repository.insert(new Course(22, "Hunger Games", "SC"));
//        repository.insert(new Course(44, "Book Thief", "Zusac"));

        repository.save(new Course(55, "Introduction to Harry Potter", "Rowling"));
        repository.save(new Course(22, "Hunger Games", "Collins"));
        repository.save(new Course(35, "Fire is Catching", "Collins"));
        repository.save(new Course(44, "Book Thief", "Zusac"));

        // repository.deleteById(22l);

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Collins"));
        System.out.println(repository.findByName("Book Thief"));

        // System.out.println(repository.findById(33));
    }

}
