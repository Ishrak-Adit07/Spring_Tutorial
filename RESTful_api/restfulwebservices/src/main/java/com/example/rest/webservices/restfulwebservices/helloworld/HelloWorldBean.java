package com.example.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    private String message;

    HelloWorldBean() {

    }

    HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [message=" + message + "]";
    }

}
