package com.basaker.mobileactionbootcamp.vhc.controller;

import com.basaker.mobileactionbootcamp.gen.response.RestResponse;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleDto;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleSaveRequestDto;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleUpdateRequestDto;
import com.basaker.mobileactionbootcamp.vhc.service.VhcVehicleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VhcVehicleController {

    private final VhcVehicleService vhcVehicleService;

    @Operation(tags = "Vehicle Controller", summary = "Get vehicles")
    @GetMapping
    public ResponseEntity findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {
        List<VhcVehicleDto> vhcVehicleDtoList = vhcVehicleService.findAll(pageOptional, sizeOptional);

        return ResponseEntity.ok(RestResponse.of(vhcVehicleDtoList));
    }

    @Operation(tags = "Vehicle Controller", summary = "Get vehicle with id")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        VhcVehicleDto vhcVehicleDto = vhcVehicleService.findById(id);

        return ResponseEntity.ok(RestResponse.of(vhcVehicleDto));
    }

    @Operation(tags = "Vehicle Controller", summary = "Save vehicle")
    @PostMapping
    public ResponseEntity save(@RequestBody VhcVehicleSaveRequestDto vhcVehicleSaveRequestDto) {

        VhcVehicleDto vhcVehicleDto = vhcVehicleService.save(vhcVehicleSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(vhcVehicleDto));
    }

    @Operation(tags = "Vehicle Controller", summary = "Delete vehicle")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        vhcVehicleService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @Operation(tags = "Vehicle Controller", summary = "Update vehicle")
    @PutMapping
    public ResponseEntity update(@RequestBody VhcVehicleUpdateRequestDto vhcVehicleUpdateRequestDto) {

        VhcVehicleDto vhcVehicleDto = vhcVehicleService.update(vhcVehicleUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(vhcVehicleDto));
    }

    @Operation(tags = "Vehicle Controller", summary = "Get vehicle with brand and model")
    @GetMapping("/{brand}/{model}")
    public ResponseEntity<List<VhcVehicleDto>> findByBrandandModel(@PathVariable String brand, @PathVariable String model) {

        return ResponseEntity.ok(vhcVehicleService.getVehiclesbyBrandAndModel(brand, model));
    }

}
