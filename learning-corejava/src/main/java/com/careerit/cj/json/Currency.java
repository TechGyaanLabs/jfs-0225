package com.careerit.cj.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Currency {
    private String symbol;
    private String name;
    private String symbolNative;
    private int decimalDigits;
    private int rounding;
    private String code;
    private String namePlural;
}
