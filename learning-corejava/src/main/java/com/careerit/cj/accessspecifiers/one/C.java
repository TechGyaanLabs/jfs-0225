package com.careerit.cj.accessspecifiers.one;

public class C {

    A obj = new A();

    public void display(){
        //System.out.println(obj.pri_num);
        System.out.println(obj.def_num);
        System.out.println(obj.pro_num);
        System.out.println(obj.pub_num);
    }
}
