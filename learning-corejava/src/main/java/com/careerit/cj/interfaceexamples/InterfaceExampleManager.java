package com.careerit.cj.interfaceexamples;

interface I1{
    void m1();
}
interface I2 {
    void m2();
}
interface I3 extends I1, I2{
    void m3();
}

class C1 implements I1,I2,I3{

    @Override
    public void m3() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m1() {

    }
}

public class InterfaceExampleManager {
}
