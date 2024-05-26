package com.dmd.identityservice.service;

import com.dmd.identityservice.dto.request.UserCreateReq;
import com.dmd.identityservice.dto.request.UserUpdateReq;
import com.dmd.identityservice.dto.response.UserResponse;
import com.dmd.identityservice.entity.User;
import com.dmd.identityservice.mapper.UserMapper;
import com.dmd.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User create(UserCreateReq request) {

        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("duplicate username");
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dob(request.getDob()).build();

        User user1 = userMapper.toUser(request);

        return userRepository.save(user1);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public UserResponse select(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found")));
    }

    public User update(String id, UserUpdateReq request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        userMapper.updateUser(user,request);
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
