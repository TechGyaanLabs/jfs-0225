package com.careerit.jfs.invoice;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Invoice {
    private String id;
    private String date;
    private String dueDate;
    private String status;
    private String currency;

    private Seller seller;
    private Buyer buyer;
    private List<Item> items;
    private Summary summary;

    private String notes;
}