package com.example.fitnessclub;


public class ManageTimeSlotData {

    private String name, time;
//    private int pic;

//    public int getPic() {
//        return pic;
//    }
//
//    public void setPic(int pic) {
//        this.pic = pic;
//    }

    public ManageTimeSlotData(String name, String time) {
        this.name = name;
        this.time = time;
//        this.pic = pic;


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
