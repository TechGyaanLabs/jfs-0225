package com.careerit.cj.accessspecifiers.one;

public class A {

    private  int pri_num = 10;
    int def_num = 40;
    protected int pro_num = 20;
    public int pub_num = 30;


    public void display(){
        System.out.println("pri_num:"+pri_num);
        System.out.println("def_num:"+def_num);
        System.out.println("pro_num:"+pro_num);
        System.out.println("pub_num:"+pub_num);
    }

}
