package com.careerit.cbook.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ContactDto {
    private UUID id;
    private String name;
    private String email;
    private String mobile;
    private String city;
    private LocalDate dob;
    private boolean deleted;
}
