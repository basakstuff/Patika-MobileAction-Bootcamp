package com.basaker.mobileactionbootcamp.usr.controller;

/**
 * @author Basak Er
 * @since 1.0.0
 */

import com.basaker.mobileactionbootcamp.gen.response.RestResponse;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserPasswordDto;
import com.basaker.mobileactionbootcamp.usr.dto.UsrUserSaveRequestDto;
import com.basaker.mobileactionbootcamp.usr.service.UsrUserService;
import com.basaker.mobileactionbootcamp.vhc.dto.VhcVehicleDto;
import com.basaker.mobileactionbootcamp.vhc.service.VhcVehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsrUserController {

    public final VhcVehicleService vhcVehicleService;
    private final UsrUserService usrUserService;

    @Operation(
            tags = "User Controller",
            summary = "Gets all users"
    )
    @GetMapping
    public ResponseEntity findAll() {

        List<UsrUserDto> usrUserDtoList = usrUserService.findAll();

        return ResponseEntity.ok(RestResponse.of(usrUserDtoList));
    }

    @Operation(
            tags = "User Controller",
            summary = "Save user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "creates new user",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = UsrUserSaveRequestDto.class
                            ),
                            examples = {
                                    @ExampleObject(
                                            name = "Turkish Citizen",
                                            summary = "New Turkish Citizen User",
                                            value = "{\n" +
                                                    "  \"name\": \"ahmet\",\n" +
                                                    "  \"surname\": \"kurt\",\n" +
                                                    "  \"username\": ahmetkurt,\n" +
                                                    "  \"password\": \"Ahmet.1234\"\n" +
                                                    "}"
                                    ),
                                    @ExampleObject(
                                            name = "Foreign Citizen",
                                            summary = "New Foreign Citizen User",
                                            value = "{\n" +
                                                    "  \"name\": \"john\",\n" +
                                                    "  \"surname\": \"grant\",\n" +
                                                    "  \"username\": johngrant,\n" +
                                                    "  \"password\": \"John.1234\"\n" +
                                                    "}"
                                    )
                            }
                    )
            )
    )

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUserDto usrUserDto = usrUserService.save(usrUserSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

    @Operation(tags = "User Controller", summary = "Get user with id")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        UsrUserDto usrUserDto = usrUserService.findById(id);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

    @Operation(tags = "User Controller", summary = "Delete user with id")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        usrUserService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }


    @Operation(tags = "User Controller", summary = "Update password")
    @PatchMapping("/password/{id}")
    public ResponseEntity updatePassword(@RequestBody UsrUserPasswordDto usrUserPasswordDto) {

        UsrUserDto usrUserDto = usrUserService.updatePassword(usrUserPasswordDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

    @Operation(tags = "User Controller", summary = "Get vehicles with user id")
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<List<VhcVehicleDto>> findAllVehiclesById(Long id) {

        List<VhcVehicleDto> vehicleDtoList = vhcVehicleService.findAllVehiclesById(id);

        return ResponseEntity.ok(vehicleDtoList);
    }


}
