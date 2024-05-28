package com.dmd.identityservice.service;

import com.dmd.identityservice.dto.request.AuthenticationReq;
import com.dmd.identityservice.exception.AppException;
import com.dmd.identityservice.exception.ErrorCode;
import com.dmd.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class AuthenticationService {
    UserRepository repository;

    public boolean authenticate(AuthenticationReq req) {
        var user = repository.findByUsername(req.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(req.getPassword(), user.getPassword());
    }
}
