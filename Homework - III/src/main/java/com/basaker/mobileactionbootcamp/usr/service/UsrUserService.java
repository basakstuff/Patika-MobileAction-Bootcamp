package com.basaker.mobileactionbootcamp.usr.service;

import com.basaker.mobileactionbootcamp.gen.exceptions.DuplicateException;
import com.basaker.mobileactionbootcamp.gen.exceptions.GenBusinessException;
import com.basaker.mobileactionbootcamp.usr.converter.UsrUserMapper;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserPasswordDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserSaveRequestDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserUpdateRequestDto;
import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import com.basaker.mobileactionbootcamp.usr.enums.UsrErrorMessage;
import com.basaker.mobileactionbootcamp.usr.exceptions.UsrUserErrorMessage;
import com.basaker.mobileactionbootcamp.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;
    private final PasswordEncoder passwordEncoder;

    public List<UsrUserDto> findAll() {

        List<UsrUser> usrUserList = usrUserEntityService.findAll();

        List<UsrUserDto> usrUserDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);

        return usrUserDtoList;
    }

    public UsrUserDto save(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveRequestDto);

        usrUser = encodeUserPassword(usrUser);

        usrUser = usrUserEntityService.saveWithControlUsername(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    public UsrUserDto findById(Long id) {

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    public void delete(Long id) {

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        usrUserEntityService.delete(usrUser);
    }

    public UsrUserDto update(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {

        controlIsUserExist(usrUserUpdateRequestDto);

        Long id = usrUserUpdateRequestDto.getId();

        boolean isExist = usrUserEntityService.existsById(id);
        if (!isExist) {
            throw new GenBusinessException(UsrErrorMessage.USER_DOES_NOT_EXIST);
        }

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserUpdateRequestDto);

        usrUser = usrUserEntityService.save(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    private UsrUser encodeUserPassword(UsrUser usrUser) {
        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);
        return usrUser;
    }

    private void controlIsUserExist(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {

        Long id = usrUserUpdateRequestDto.getId();
        boolean isExist = usrUserEntityService.existsById(id);

        if (!isExist) {
            throw new DuplicateException(UsrUserErrorMessage.USER_NOT_FOUND);
        }

        String username = usrUserUpdateRequestDto.getUsername();
        Optional<UsrUser> usrUser = Optional.ofNullable(usrUserEntityService.findByUsername(username));


        if (usrUser.isPresent() && !Objects.equals(usrUser.get().getId(), id)) {
            throw new DuplicateException(UsrUserErrorMessage.USERNAME_ALREADY_EXIST);
        }
    }

    public UsrUserDto updatePassword(UsrUserPasswordDto usrUserPasswordDto) {


        UsrUser usrUser = usrUserEntityService.findByIdWithControl(usrUserPasswordDto.getId());

        String oldPassword = passwordEncoder.encode(usrUserPasswordDto.getOldPassword());
        String newPassword = passwordEncoder.encode(usrUserPasswordDto.getNewPassword());
        String newPasswordAgain = passwordEncoder.encode(usrUserPasswordDto.getNewPasswordAgain());


        if (!(usrUserPasswordDto.getNewPassword().equals(usrUserPasswordDto.getNewPasswordAgain()))) {
            throw new DuplicateException(UsrUserErrorMessage.USERNAME_PASSWORD_DO_NOT_MATCH);
        }


        usrUser.setPassword(passwordEncoder.encode(usrUserPasswordDto.getNewPassword()));
        usrUser = usrUserEntityService.save(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }


}
