package com.careerit.jfs.invoice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Summary {
    private double subTotal;
    private Tax tax;
    private double total;
    private double amountPaid;
    private double balanceDue;
}