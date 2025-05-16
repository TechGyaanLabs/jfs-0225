package com.careerit.cbook.domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "country_info")
public class CountryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String commonName;
    private String officialName;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> capital;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String,String> languages;
    private String region;
    private String ccn3;
    private double population;
    private double area;
    private String flagSvg;

}
