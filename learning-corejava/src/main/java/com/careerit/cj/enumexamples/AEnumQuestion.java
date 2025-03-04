package com.careerit.cj.enumexamples;

import java.time.LocalDate;

enum Month{
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}


class Booking{
    private LocalDate bookingDate;
    private Month month;
    private double price;

    public Booking(LocalDate bookingDate, Month month, double price) {
        this.bookingDate = bookingDate;
        this.month = month;
        this.price = price;
    }
    public Month getMonth() {
        return month;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

}

public class AEnumQuestion {

    public static void main(String[] args) {

        Booking booking1 = new Booking(LocalDate.of(2025, 1, 5), Month.JANUARY, 1000);
        Booking booking2 = new Booking(LocalDate.of(2024, 2, 1), Month.FEBRUARY, 2000);
        Booking booking3 = new Booking(LocalDate.of(2025, 2, 15), Month.MARCH, 3000);
        Booking booking4 = new Booking(LocalDate.of(2025, 3, 5), Month.APRIL, 4000);

        Booking[] arr = {booking1, booking2, booking3, booking4};

        // Calculate total amount of all the bookings. Here price is per day and booking end every month end.



    }
}
