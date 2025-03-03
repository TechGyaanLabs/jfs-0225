package com.careerit.cj;

enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}

enum days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum ApprovalStatus {
    APPROVED, REJECTED, PENDING
}

enum InvoiceType{
    CHARGE, PAYOUT
}

public class EnumExample {

    public static void main(String[] args) {
        Month month = Month.JAN;
        int days = getDays(Month.FEB, 2024);
        System.out.println(days);
    }

    public static int getDays(Month month, int year) {

        return switch (month) {
            case JAN, MAR, MAY, JUL, AUG, OCT, DEC -> 31;
            case APR, JUN, SEP, NOV -> 30;
            case FEB -> {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                    yield 29;
                else
                    yield 28;
            }
            default -> throw new IllegalArgumentException("Invalid Month");
        };

    }
}
