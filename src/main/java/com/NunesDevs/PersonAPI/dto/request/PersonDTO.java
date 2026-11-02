package com.NunesDevs.PersonAPI.dto.request;

import com.NunesDevs.PersonAPI.entity.Address;
import com.NunesDevs.PersonAPI.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @jakarta.validation.constraints.NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @jakarta.validation.constraints.NotBlank
    @CPF
    private String cpf;

    @jakarta.validation.constraints.NotNull
    @jakarta.validation.constraints.PastOrPresent
    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    @NotEmpty
    private List<AddressDTO> address;
}
