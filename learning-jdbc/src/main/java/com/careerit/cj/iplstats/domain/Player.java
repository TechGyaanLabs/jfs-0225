package com.careerit.cj.iplstats.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private UUID id;
    private String name;
    private String role;
    private String team;
    private String country;
    private double amount;
}
