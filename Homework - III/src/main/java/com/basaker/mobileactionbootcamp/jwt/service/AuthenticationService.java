package com.basaker.mobileactionbootcamp.jwt.service;

import com.basaker.mobileactionbootcamp.usr.dto.UsrUserDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserSaveRequestDto;
import com.basaker.mobileactionbootcamp.usr.service.UsrUserService;
import com.basaker.mobileactionbootcamp.jwt.dto.JwtLoginRequestDto;
import com.basaker.mobileactionbootcamp.jwt.enums.JwtConstant;
import com.basaker.mobileactionbootcamp.jwt.security.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UsrUserService usrUserService;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UsrUserDto register(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        return usrUserService.save(usrUserSaveRequestDto);
    }

    public String login(JwtLoginRequestDto jwtLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtLoginRequestDto.getUsername().toString(), jwtLoginRequestDto.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String fullToken = JwtConstant.BEARER.getConstant() + token;

        return fullToken;
    }
}
