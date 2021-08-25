package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import com.codeup.blogapp.data.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping()
    private List<User> UsersController(){
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {

        userRepository.save(newUser);
    }

    @PutMapping("/{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping({"/{id}"})
    private void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    //    @GetMapping("/{id}")//    private User findByID(@PathVariable Long id) {//        return new User(1L, "User", "email@email.com", "password");////    }
    @GetMapping("/findByUsername/{username}")
    private User findByUsername(@PathVariable String username) {
        return userRepository.findFirstByUsername(username);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email) {
        return userRepository.findFirstByEmail(email);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        User user = userRepository.getById(id);
        user.setPassword(newPassword);
        userRepository.save(user);
    }
}
















