package com.careerit.jfs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConfigData {
    private String name;
    private List<String> locations;
    private String welcome;
}