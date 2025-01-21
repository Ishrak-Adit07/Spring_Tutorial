package com.example.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        super();
        this.name = name;
    }

    public PersonV2(String firstName, String lastName) {
        super();
        this.name = new Name(firstName, lastName);
    }

    public Name getName() {
        return name;
    }

}
