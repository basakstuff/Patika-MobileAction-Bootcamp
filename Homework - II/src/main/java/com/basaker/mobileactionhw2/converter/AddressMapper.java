package com.basaker.mobileactionhw2.converter;

import com.basaker.mobileactionhw2.dto.AddressResponseDto;
import com.basaker.mobileactionhw2.dto.AddressSaveRequestDto;
import com.basaker.mobileactionhw2.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address convertToAddress(AddressSaveRequestDto addressSaveRequestDto);

    AddressResponseDto convertToAddressResponseDto(Address address);

}
