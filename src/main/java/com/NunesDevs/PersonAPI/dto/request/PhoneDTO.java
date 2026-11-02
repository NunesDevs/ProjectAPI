package com.NunesDevs.PersonAPI.dto.request;

import com.NunesDevs.PersonAPI.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PhoneDTO {

    private Long id;

    @jakarta.validation.constraints.NotNull
    private PhoneType type;

    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Pattern(regexp = "[+]?[0-9]{10,15}")
    private String number;

}
