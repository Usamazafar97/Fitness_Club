package com.example.fitnessclub;


public class ManageTimeSlotData {

    private String name, time;

    public ManageTimeSlotData(String name, String time) {
        this.name = name;
        this.time = time;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
