package com.NunesDevs.PersonAPI.dto.request;

import com.NunesDevs.PersonAPI.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    @NotEmpty
    @Size(min = 8, max = 10)
    private String cep;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String street;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String district;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String city;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String state;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String country;
}
