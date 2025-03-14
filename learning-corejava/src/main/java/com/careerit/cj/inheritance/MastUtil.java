package com.careerit.cj.inheritance;

public final class MastUtil {

    private MastUtil() {
    }

    public static String accNumber(String accountNumber) {
        return "*******"+accountNumber.substring(accountNumber.length()-3);
    }
}
