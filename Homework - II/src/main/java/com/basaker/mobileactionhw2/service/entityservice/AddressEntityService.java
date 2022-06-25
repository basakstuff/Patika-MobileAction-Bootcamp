package com.basaker.mobileactionhw2.service.entityservice;

import com.basaker.mobileactionhw2.converter.AddressMapper;
import com.basaker.mobileactionhw2.dao.AddressDao;
import com.basaker.mobileactionhw2.dto.AddressDetailDto;
import com.basaker.mobileactionhw2.dto.AddressResponseDto;
import com.basaker.mobileactionhw2.dto.AddressSaveRequestDto;
import com.basaker.mobileactionhw2.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Service
@RequiredArgsConstructor
public class AddressEntityService {

    private final AddressDao addressDao;

    public AddressResponseDto save(AddressSaveRequestDto addressSaveRequestDto) {

        Address address = AddressMapper.INSTANCE.convertToAddress(addressSaveRequestDto);

        address = addressDao.save(address);

        AddressResponseDto addressResponseDto = AddressMapper.INSTANCE.convertToAddressResponseDto(address);

        return addressResponseDto;
    }

    public void delete(Long id) {

        Address address = getById(id);

        addressDao.delete(address);
    }

    public AddressResponseDto findById(Long id) {

        Address address = getById(id);

        AddressResponseDto addressResponseDto = AddressMapper.INSTANCE.convertToAddressResponseDto(address);

        return addressResponseDto;
    }

    public AddressDetailDto findAddressDetails(Long id) {
        return addressDao.findAddressDetails(id);
    }

    private Address getById(Long id) {

        Optional<Address> addressOptional = addressDao.findById(id);

        Address address;
        if (addressOptional.isPresent()) {
            address = addressOptional.get();
        } else {
            throw new RuntimeException("Address not found");
        }
        return address;
    }
}
