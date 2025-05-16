package com.careerit.cbook.dto;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CountryInfoDto {
    private UUID id;
    private String commonName;
    private String officialName;
    private List<String> capital;
    private Map<String,String> languages;
    private String region;
    private String ccn3;
    private double population;
    private double area;
    private String flagSvg;
}
