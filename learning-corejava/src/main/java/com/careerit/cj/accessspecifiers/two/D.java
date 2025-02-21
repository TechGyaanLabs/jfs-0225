package com.careerit.cj.accessspecifiers.two;

import com.careerit.cj.accessspecifiers.one.A;
import com.careerit.cj.accessspecifiers.one.C;

public class D extends A {

    public void display() {
        //System.out.println(pri_num);
        //System.out.println(def_num);
        System.out.println(pro_num);
        System.out.println(pub_num);
    }
}
