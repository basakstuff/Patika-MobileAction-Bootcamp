package com.basaker.homeworki.controller;

import com.basaker.homeworki.dao.UserDao;
import com.basaker.homeworki.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAllUser() {

        List<User> userList = userDao.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findAllUserById(@PathVariable Long id) {

        User myUser = userDao.findById(id).orElseThrow();
        return ResponseEntity.ok(myUser);
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody User user) {

        user = userDao.save(user);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody User user) {

        if (user.getId() == null) {
            throw new RuntimeException("User id cannot be empty");
        }
        boolean isExist = userDao.existsById(user.getId());
        if (!isExist) {
            throw new RuntimeException("User does not exits");
        }

        user = userDao.save(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/passive/{id}")
    public ResponseEntity makePassive(@PathVariable Long id) {

        User user = userDao.findById(id).orElseThrow();
        user.setIsActive(Boolean.FALSE);
        user = userDao.save(user);
        return ResponseEntity.ok(user);
    }


}