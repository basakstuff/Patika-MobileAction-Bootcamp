package com.basaker.mobileactionbootcamp.jwt.controller;

import com.basaker.mobileactionbootcamp.usr.dto.UsrUserDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserSaveRequestDto;
import com.basaker.mobileactionbootcamp.gen.response.RestResponse;
import com.basaker.mobileactionbootcamp.jwt.dto.JwtLoginRequestDto;
import com.basaker.mobileactionbootcamp.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity save(@Valid @RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){

        UsrUserDto usrUserDto = authenticationService.register(usrUserSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JwtLoginRequestDto jwtLoginRequestDto){

        String login = authenticationService.login(jwtLoginRequestDto);

        return ResponseEntity.ok(RestResponse.of(login));
    }
}
