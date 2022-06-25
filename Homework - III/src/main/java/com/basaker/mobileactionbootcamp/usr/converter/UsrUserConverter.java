package com.basaker.mobileactionbootcamp.usr.converter;

import com.basaker.mobileactionbootcamp.usr.dto.UsrUserDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserSaveRequestDto;
import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
public class UsrUserConverter {

    public UsrUser convertToUsrUser(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUser usrUser = new UsrUser();
        usrUser.setName(usrUserSaveRequestDto.getName());
        usrUser.setSurname(usrUserSaveRequestDto.getSurname());
        usrUser.setUsername(usrUserSaveRequestDto.getUsername());
        usrUser.setPassword(usrUserSaveRequestDto.getPassword());

        return usrUser;
    }

    public List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList) {

        List<UsrUserDto> usrUserDtoList = new ArrayList<>();
        for (UsrUser usrUser : usrUserList) {
            UsrUserDto usrUserDto = convertToUsrUserDto(usrUser);
            usrUserDtoList.add(usrUserDto);
        }

        return usrUserDtoList;
    }

    public UsrUserDto convertToUsrUserDto(UsrUser usrUser) {

        UsrUserDto usrUserDto = new UsrUserDto();
        usrUserDto.setId(usrUser.getId());
        usrUserDto.setName(usrUser.getName());
        usrUserDto.setSurname(usrUser.getSurname());
        usrUserDto.setUsername(usrUser.getUsername());

        return usrUserDto;
    }
}
