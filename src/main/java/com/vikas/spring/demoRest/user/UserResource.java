package com.vikas.spring.demoRest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    //retrieveAll resource
    //GET /users
    @Autowired
    private UserDaoService service;
    @RequestMapping(method = RequestMethod.GET, path="users")
    public List<User> retriveAllUsers(){
        return service.findAll();

    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){

        User user= service.findOne(id);
        if (user==null){
            throw new UserNotFoundException("id: ->"+id);

        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser= service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

   /* @DeleteMapping ("/users/{name}")
    public void deleteUser(@PathVariable String name){
        service.delete(name);

    }*/

    @DeleteMapping ("/users/{id}")
    public void deleteUserId(@PathVariable int id){
        User user= service.deleteById(id);
        if (user==null){
            throw new UserNotFoundException("id: ->"+id);

        }

    }




}
