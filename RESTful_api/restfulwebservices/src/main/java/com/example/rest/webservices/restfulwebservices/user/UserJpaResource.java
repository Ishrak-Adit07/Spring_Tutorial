package com.example.rest.webservices.restfulwebservices.user;

import com.example.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.example.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private UserRepository repository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    // GET /users
    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    // GET /user/1
    @GetMapping(path = "/jpa/user/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id) {

        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+id);

        EntityModel<User> entityModel = EntityModel.of(user.get());
        return entityModel;
    }

    @GetMapping(path = "/jpa/user/{id}/posts")
    public List<Post> retrievePostsByUserId(@PathVariable int id) {

        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+id);

        return user.get().getPosts();
    }

    // POST /jpa/user/2/post/create
    @PostMapping(path = "/jpa/user/{id}/post/create")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {

        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+id);

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // DELETE /user/delete/1
    @DeleteMapping(path = "/jpa/user/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

}
