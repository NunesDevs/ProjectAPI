package com.NunesDevs.PersonAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum AddressType {

    FIRST("Home"),
    SECOND("Second option"),
    THIRD("Third option");

    private final String descriptions;

}
