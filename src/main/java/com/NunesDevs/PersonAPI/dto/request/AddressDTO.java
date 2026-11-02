package com.NunesDevs.PersonAPI.dto.request;

import com.NunesDevs.PersonAPI.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {

    private Long id;

    @jakarta.validation.constraints.NotNull
    private AddressType type;

    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(regexp = "[0-9]{5}-?[0-9]{3}")
    private String cep;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String street;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String district;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String city;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String state;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String country;
}
