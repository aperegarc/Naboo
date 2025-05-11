package com.naboo.primera_fase.controllers;

import com.naboo.primera_fase.entity.User;
import com.naboo.primera_fase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<User> listarUsers() {
        return userService.getAllUsers();
    }


    // @GetMapping("/{name}")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        for (User user : userService.getAllUsers()) {
            if (user.getName().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }


    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User nuevoUser) {
        userService.saveUser(nuevoUser);
        return ResponseEntity.ok(nuevoUser);
    }


    // @PutMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User putUser(@PathVariable Integer id, @RequestBody User nuevoUser){
        return userService.updateUser(id, nuevoUser);
    }

    // @DeleteMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<User> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return userService.getAllUsers();
    }

}
