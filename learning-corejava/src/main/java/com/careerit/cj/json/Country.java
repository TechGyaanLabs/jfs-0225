package com.careerit.cj.json;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country {
    private String commonName;
    private String officialName;
    private List<String> capitals;
    private String region;
    private double population;
    private double area;
    private String flagSvgUrl;
}
