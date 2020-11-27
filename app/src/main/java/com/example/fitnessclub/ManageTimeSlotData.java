package com.example.fitnessclub;


public class ManageTimeSlotData {

    private String name, start_time,end_time;
//    private int pic;

//    public int getPic() {
//        return pic;
//    }
//
//    public void setPic(int pic) {
//        this.pic = pic;
//    }

    public ManageTimeSlotData(String name, String start_time) {
        this.name = name;
        this.start_time = start_time;
//        this.pic = pic;


    }

    public ManageTimeSlotData() {
        this.name = "";
        this.start_time = "";
        this.end_time = "";
    }

    public ManageTimeSlotData(String name, String start_time, String end_time) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return start_time;
    }

    public void setStartTime(String start_time) {
        this.start_time = start_time;
    }

}
