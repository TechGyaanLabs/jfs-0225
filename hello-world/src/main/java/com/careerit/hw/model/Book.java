package com.careerit.hw.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Book {
    private UUID id;
    private String title;
    private String author;
    private double price;
}
