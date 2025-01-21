package com.example.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // GET /users
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

//     GET /user/1
//    @GetMapping(path = "/user/{id}")
//    public EntityModel<User> retrieveUserById(@PathVariable int id) {
//        User user = service.findById(id);
//        if(user == null)
//            throw new UserNotFoundException("id: "+id);
//
//        EntityModel<User> entityModel = EntityModel.of(user);
//        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
//        entityModel.add(link.withRel("all-users"));
//
//        return entityModel;
//    }

    // GET /user/1
    @GetMapping(path = "/user/{id}")
    public User retrieveUserById(@PathVariable int id) {
        User user = service.findById(id);
        if(user == null)
            throw new UserNotFoundException("id: "+id);
        return user;
    }

    // POST /user/create
    @PostMapping(path = "/user/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // DELETE /user/delete/1
    @DeleteMapping(path = "/user/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

}
