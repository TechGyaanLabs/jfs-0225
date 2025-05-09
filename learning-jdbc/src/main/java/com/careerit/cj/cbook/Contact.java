package com.careerit.cj.cbook;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Contact {
    private UUID id;
    private String name;
    private String email;
    private String mobile;
    private boolean deleted;
}
