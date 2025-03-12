package com.careerit.cj.finalvariables;

class C1{

}
class C2 extends C1{
}


class CM1 {
    public C1 m1(){
        return new C1();
    }
}
class CM2 extends CM1{

    public C2 m1(){
        return new C2();
    }
}

public class OverrideExample2 {
}
