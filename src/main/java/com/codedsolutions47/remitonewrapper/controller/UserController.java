package com.codedsolutions47.remitonewrapper.controller;

import com.codedsolutions47.remitonewrapper.model.entity.User;
import com.codedsolutions47.remitonewrapper.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/partners")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        userService.createUser(user);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/reset-password")
//    public ResponseEntity<Void> resetPassword(@RequestParam String username, @RequestParam String newPassword) {
//        userService.resetPassword(username, newPassword);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
