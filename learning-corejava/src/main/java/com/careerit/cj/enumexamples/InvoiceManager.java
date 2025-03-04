package com.careerit.cj.enumexamples;

enum InvoiceStatus {
    DRAFT, APPROVED, REJECTED
}

class Invoice{
    String invoiceNumber;
    String customerName;
    InvoiceStatus status;
    double totalAmount;

    Invoice(String invoiceNumber, String customerName, InvoiceStatus status, double totalAmount) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.status = status;
        this.totalAmount = totalAmount;
    }
    public void showDetails(){
        System.out.println("Invoice Number: "+invoiceNumber);
        System.out.println("Customer Name: "+customerName);
        System.out.println("Status: "+status);
        System.out.println("Total Amount: "+totalAmount);
    }
}

public class InvoiceManager {

    public static void main(String[] args) {

        // Create 10 invoice object store it in an array.

        // Find total amount of Approved invoices.
    }
}
