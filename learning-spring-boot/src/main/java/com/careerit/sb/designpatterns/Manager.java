package com.careerit.sb.designpatterns;

public class Manager {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            TaskManager obj = TaskManager.getInstance();
            System.out.println(obj);
        });

        Thread t2 = new Thread(() -> {
            TaskManager obj = TaskManager.getInstance();
            System.out.println(obj);
        });

        Thread t3 = new Thread(() -> {
            TaskManager obj = TaskManager.getInstance();
            System.out.println(obj);
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
