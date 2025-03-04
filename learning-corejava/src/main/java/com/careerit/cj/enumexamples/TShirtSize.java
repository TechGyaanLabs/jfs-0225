package com.careerit.cj.enumexamples;

public enum TShirtSize {
    SMALL(38), MEDIUM(40), LARGE(42), XLARGE(44);


    final int size;

    TShirtSize(int size) {
        this.size = size;
    }

    public static TShirtSize valueOfSize(int size) {

        for(TShirtSize sizeEnum:TShirtSize.values()) {
            if(sizeEnum.size == size) {
                return sizeEnum;
            }
        }
        throw new IllegalArgumentException("Invalid Size");
    }
    int getSize() {
        return size;
    }
}
