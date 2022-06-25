package com.basaker.mobileactionbootcamp.vhc.converter;

import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleDto;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleSaveRequestDto;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleUpdateRequestDto;
import com.basaker.mobileactionbootcamp.vhc.entity.VhcVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VhcVehicleMapper {

    VhcVehicleMapper INSTANCE = Mappers.getMapper(VhcVehicleMapper.class);

    @Mapping(target = "usrUserId", source = "usrUser.id")
    VhcVehicleDto convertToVhcVehicleDto(VhcVehicle vhcVehicle);

    List<VhcVehicleDto> convertToVhcVehicleDtoList(List<VhcVehicle> vhcVehicleList);

    VhcVehicle convertToVhcVehicle(VhcVehicleSaveRequestDto vhcVehicleSaveRequestDto);

    VhcVehicle convertToVhcVehicleUpdate(VhcVehicleUpdateRequestDto VvcVehicleUpdateRequestDto);


}

