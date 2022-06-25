package com.basaker.mobileactionbootcamp.vhc.service;


import com.basaker.mobileactionbootcamp.gen.exceptions.GenBusinessException;
import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import com.basaker.mobileactionbootcamp.usr.service.entityservice.UsrUserEntityService;
import com.basaker.mobileactionbootcamp.vhc.Exceptions.VhcVehicleErrorMessage;
import com.basaker.mobileactionbootcamp.vhc.converter.VhcVehicleMapper;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleDto;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleSaveRequestDto;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleUpdateRequestDto;
import com.basaker.mobileactionbootcamp.vhc.entity.VhcVehicle;
import com.basaker.mobileactionbootcamp.vhc.service.entityservice.VhcVehicleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class VhcVehicleService {

    private final VhcVehicleEntityService vhcVehicleEntityService;
    private final UsrUserEntityService usrUserEntityService; // TODO: remove

    public List<VhcVehicleDto> findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {

        List<VhcVehicle> vhcVehicleList = vhcVehicleEntityService.findAll(pageOptional, sizeOptional);

        List<VhcVehicleDto> vhcVehicleDtoList = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDtoList(vhcVehicleList);

        return vhcVehicleDtoList;
    }

    public VhcVehicleDto findById(Long id) {

        VhcVehicle vhcVehicle = vhcVehicleEntityService.findByIdWithControl(id);

        VhcVehicleDto vhcVehicleDto = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDto(vhcVehicle);

        return vhcVehicleDto;
    }

    public VhcVehicleDto save(VhcVehicleSaveRequestDto vhcVehicleSaveRequestDto) {

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(vhcVehicleSaveRequestDto.getUsrUserId());

        VhcVehicle vhcVehicle = VhcVehicleMapper.INSTANCE.convertToVhcVehicle(vhcVehicleSaveRequestDto);

        vhcVehicle = vhcVehicleEntityService.saveWithControlPlate(vhcVehicle);

        VhcVehicleDto vhcVehicleDto = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDto(vhcVehicle);

        return vhcVehicleDto;
    }

    private VhcVehicle createVhcVehicle(UsrUser usrUser, String brand, String model, String plate) {


        VhcVehicle vhcVehicle = new VhcVehicle();
        vhcVehicle.setUsrUser(usrUser);

        vhcVehicle.setBrand(brand);
        vhcVehicle.setModel(model);
        vhcVehicle.setPlate(plate);

        vhcVehicle = vhcVehicleEntityService.save(vhcVehicle);
        return vhcVehicle;
    }

    public VhcVehicleDto update(VhcVehicleUpdateRequestDto vhcVehicleUpdateRequestDto) {

        controlIsVehicleExists(vhcVehicleUpdateRequestDto);

        Long id = vhcVehicleUpdateRequestDto.getId();

        VhcVehicle vhcVehicle = VhcVehicleMapper.INSTANCE.convertToVhcVehicleUpdate(vhcVehicleUpdateRequestDto);

        vhcVehicle = vhcVehicleEntityService.save(vhcVehicle);

        VhcVehicleDto vhcVehicleDto = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDto(vhcVehicle);

        return vhcVehicleDto;
    }

    public void delete(Long id) {

        VhcVehicle vhcVehicle = vhcVehicleEntityService.findByIdWithControl(id);

        vhcVehicleEntityService.delete(vhcVehicle);
    }

    private void controlIsVehicleExists(VhcVehicleUpdateRequestDto vhcVehicleUpdateRequestDto) {

        Long id = vhcVehicleUpdateRequestDto.getId();
        boolean isExist = vhcVehicleEntityService.existsById(id);

        if (!isExist) {
            throw new GenBusinessException(VhcVehicleErrorMessage.VEHICLE_NOT_EXIST);
        }

    }

    public List<VhcVehicleDto> findAllVehiclesById(Long id) {


        List<VhcVehicle> vehicleList = vhcVehicleEntityService.findAll();

        if (!vehicleList.isEmpty()) {
            vehicleList.removeIf(vehicle -> vehicle.getUsrUser().getId() != id);
        }

        if (vehicleList.isEmpty()) {
            return Collections.emptyList();
        }

        List<VhcVehicleDto> vehicleDtoList = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDtoList(vehicleList);

        return vehicleDtoList;

    }


    public List<VhcVehicleDto> getVehiclesbyBrandAndModel(String brand, String model) {


        List<VhcVehicle> vehicleList = vhcVehicleEntityService.findAll();

        if (!vehicleList.isEmpty()) {
            vehicleList.removeIf(vehicle -> !vehicle.getBrand().equals(brand));
            vehicleList.removeIf(vehicle -> !vehicle.getModel().equals(model));
        }

        if (vehicleList.isEmpty()) {
            throw new GenBusinessException(VhcVehicleErrorMessage.VEHICLE_NOT_EXIST);
        }

        List<VhcVehicleDto> vehicleDtoList = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDtoList(vehicleList);

        return vehicleDtoList;

    }


}
