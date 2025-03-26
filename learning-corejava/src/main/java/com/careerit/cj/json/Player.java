package com.careerit.cj.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    private String name;
    private String team;
    private String role;
    private String country;
    private double amount;
}
