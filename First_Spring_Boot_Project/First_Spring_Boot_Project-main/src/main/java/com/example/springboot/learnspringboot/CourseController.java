package com.example.springboot.learnspringboot;

//    http://localhost:8080/courses
//    Course{
//        "id" : 1,
//        "name" : "Learn Spring Boot",
//        "author" : "Adit"
//    }

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

class Course {
    private int id;
    private String name;
    private String author;

    Course(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

@RestController
public class CourseController {

    private List<Course> courses;
    CourseController() {
        courses = new ArrayList<>(
                List.of(
                        new Course(1, "Learn Spring Boot", "Adit"),
                        new Course(2, "Learn Java", "John"),
                        new Course(3, "Learn Kubernetes", "Doe"),
                        new Course(3, "Learn Daredevil", "MM9")
                )
        );
    }

    @RequestMapping("/courses")
    public List<Course>  retrieveAllCourses() {
        return courses;
    }

}
