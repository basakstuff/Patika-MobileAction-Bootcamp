package com.basaker.mobileactionbootcamp.jwt.security;

import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import com.basaker.mobileactionbootcamp.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UsrUserEntityService usrUserEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsrUser usrUser = usrUserEntityService.findByUsername(username);

        return JwtUserDetails.create(usrUser);
    }

    public UserDetails loadByUserId(Long id){

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        return JwtUserDetails.create(usrUser);
    }
}
