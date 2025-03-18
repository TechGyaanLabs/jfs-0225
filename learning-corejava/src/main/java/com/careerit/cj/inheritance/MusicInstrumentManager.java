package com.careerit.cj.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class MusicInstrument {
    void sound() {
        System.out.println("Instrument will make some sound");
    }
}

class Piano extends MusicInstrument {
    void sound() {
        System.out.println("PEE PEE PEE PEE PEE");
    }
}

class Guitar extends MusicInstrument {
    void sound() {
        System.out.println("TIN TIN TIN TIN TIN");
    }
}

class Flute extends MusicInstrument {
    void sound() {
        System.out.println("FLUE... FLUE... FLUE...");
    }
}

public class MusicInstrumentManager {

    public static void main(String[] args) {
        List<MusicInstrument> instruments = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int num = ThreadLocalRandom.current().nextInt(1, 4);
            MusicInstrument obj = getMusicInstrument(num);
            instruments.add(obj);
        }
        System.out.println("Total instruments created : "+instruments.size());
        for(MusicInstrument obj:instruments) {
            obj.sound();
        }
    }

    public static MusicInstrument getMusicInstrument(int num) {
        if(num == 1) {
            return new Piano();
        } else if(num == 2) {
            return new Guitar();
        } else if(num == 3) {
            return new Flute();
        }
        throw new IllegalArgumentException("Invalid Instrument");
    }
}
