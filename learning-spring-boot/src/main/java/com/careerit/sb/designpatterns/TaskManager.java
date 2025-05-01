package com.careerit.sb.designpatterns;

public class TaskManager {

    private static volatile TaskManager instance = null;

    private TaskManager(){
    }

    public static TaskManager getInstance(){
        if(instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }


}
