package com.dmd.identityservice.controller;

import com.dmd.identityservice.dto.request.UserCreateReq;
import com.dmd.identityservice.dto.request.UserUpdateReq;
import com.dmd.identityservice.dto.response.APIResponse;
import com.dmd.identityservice.dto.response.UserResponse;
import com.dmd.identityservice.entity.User;
import com.dmd.identityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreateReq request) {
        return userService.create(request);
    }
    @GetMapping
    List<User> getUsers() {
        return userService.list();
    }
    @GetMapping("/{userId}")
    APIResponse<UserResponse> select(@PathVariable("userId") String userId) {
       APIResponse<UserResponse> response = new APIResponse<>();
       response.setResult(userService.select(userId));
       return response;
    }
    @PutMapping("/{userId}")
    User update(@PathVariable("userId") String userId, @RequestBody UserUpdateReq req) {
        return userService.update(userId,req);
    }
    @DeleteMapping("/{userId}")
    String delete(@PathVariable("userId") String userId) {
        userService.delete(userId);
        return "userHasBeenDeleted";
    }
}
