package com.dmd.identityservice.controller;

import com.dmd.identityservice.dto.request.AuthenticationReq;
import com.dmd.identityservice.dto.request.IntrospectReq;
import com.dmd.identityservice.dto.response.APIResponse;
import com.dmd.identityservice.dto.response.AuthenticationRes;
import com.dmd.identityservice.dto.response.IntrospectRes;
import com.dmd.identityservice.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
    AuthenticationService service;
    @PostMapping("login")
    APIResponse<AuthenticationRes> authenticate(@RequestBody AuthenticationReq req) throws JOSEException {
        AuthenticationRes res = service.authenticate(req);
        return APIResponse.<AuthenticationRes>builder().result(res).build();
    }

    @PostMapping("introspect")
    APIResponse<IntrospectRes> authenticate(@RequestBody IntrospectReq req) throws JOSEException, ParseException {
        IntrospectRes res = service.authenticate(req);
        return APIResponse.<IntrospectRes>builder().result(res).build();
    }
}
