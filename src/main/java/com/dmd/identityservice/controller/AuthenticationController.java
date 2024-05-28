package com.dmd.identityservice.controller;

import com.dmd.identityservice.dto.request.AuthenticationReq;
import com.dmd.identityservice.dto.response.APIResponse;
import com.dmd.identityservice.dto.response.AuthenticationRes;
import com.dmd.identityservice.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
    AuthenticationService service;
    @PostMapping("login")
    APIResponse<AuthenticationRes> authenticate(@RequestBody AuthenticationReq req){
        boolean res = service.authenticate(req);
        return APIResponse.<AuthenticationRes>builder().result(AuthenticationRes.builder().isAuthenticated(res).build()).build();
    }
}
