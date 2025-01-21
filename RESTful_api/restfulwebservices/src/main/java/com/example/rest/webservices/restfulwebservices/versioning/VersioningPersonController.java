package com.example.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // URI versioning
    @GetMapping(path = "/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Ishrak Adit");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2("Ishrak", "Adit");
    }

    // Request parameters
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1WithRequestParameter() {
        return new PersonV1("Ishrak Adit");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2WithRequestParameter() {
        return new PersonV2("Ishrak", "Adit");
    }

    // Custom Headers versioning
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1WithRequestHeader() {
        return new PersonV1("Ishrak Adit");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2WithRequestHeader() {
        return new PersonV2("Ishrak", "Adit");
    }

    // Media Type versioning
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1WithAcceptHeader() {
        return new PersonV1("Ishrak Adit");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2WithAcceptHeader() {
        return new PersonV2("Ishrak", "Adit");
    }

}
