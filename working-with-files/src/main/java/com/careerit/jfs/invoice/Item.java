package com.careerit.jfs.invoice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String description;
    private int quantity;
    private double unitPrice;
    private double total;
}