package com.basaker.mobileactionbootcamp.usr.converter;

import com.basaker.mobileactionbootcamp.usr.dto.UsrUserDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserSaveRequestDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserUpdateRequestDto;
import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUser convertToUsrUser(UsrUserUpdateRequestDto usrUserUpdateRequestDto);

    UsrUserDto convertToUsrUserDto(UsrUser usrUser);

    List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList);

    UsrUser convertToUsrUser(UsrUserSaveRequestDto usrUserSaveRequestDto);
}
