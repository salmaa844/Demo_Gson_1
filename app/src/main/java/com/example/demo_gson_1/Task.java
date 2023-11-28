package com.example.demo_gson_1;

public class Task {
    private String Taskname;
    private boolean done;
    public Task(String Taskname, boolean done) {
        this.Taskname = Taskname;
        this.done = done;
    }
    public Task(String Taskname) {
        this.Taskname = Taskname;

    }

    public String getName() {
        return Taskname;
    }
    public void setName(String taskname) {Taskname = taskname;}
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
}