package com.careerit.cj.optionalexample;

import lombok.Data;

import java.util.Optional;

@Data
 class Computer {
    private Optional<Soundcard> soundcard;
    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }

}

@Data
 class Soundcard {
    private Optional<USB> usb;
    public Optional<USB> getUSB() {
        return usb;
    }

}
@Data
 class USB{
    public String getVersion(){
        return "USB 3.0";
    }
}
public class OptionalExample2 {

    public static void main(String[] args) {
        Computer lenovoThinkPad = new Computer();
        lenovoThinkPad.setSoundcard(Optional.ofNullable(null));
      /* USB usb = new USB();
       Soundcard soundcard = new Soundcard();
       soundcard.setUsb(Optional.of(usb));*/


        String version = lenovoThinkPad.getSoundcard()
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("No USB");
        System.out.println(version);
    }
}
