package com.example.fitnessclub.Model;


public class ManageTraineeData {

    private String name, phno, email;
    String address, trainerName, selectTimeSlot, ExcerciseType, membershiptype, membershipStartDate, membershipEndDate, IstransPaid;
    String mon_attend, tue_attend, wed_attend;
    String mon_train, tue_train, wed_train;

    public ManageTraineeData(String name, String phno, String email) {
        this.name = name;
        this.phno = phno;
        this.email = email;
    }

    public ManageTraineeData(String name, String phno, String email, String address, String trainerName, String selectTimeSlot, String excerciseType, String membershiptype, String membershipStartDate, String membershipEndDate, String istransPaid, String mon_attend, String tue_attend, String wed_attend, String mon_train, String tue_train, String wed_train) {
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.address = address;
        this.trainerName = trainerName;
        this.selectTimeSlot = selectTimeSlot;
        ExcerciseType = excerciseType;
        this.membershiptype = membershiptype;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        IstransPaid = istransPaid;
        this.mon_attend = mon_attend;
        this.tue_attend = tue_attend;
        this.wed_attend = wed_attend;
        this.mon_train = mon_train;
        this.tue_train = tue_train;
        this.wed_train = wed_train;
    }

    public ManageTraineeData(String name, String phno, String email, String address, String trainerName, String selectTimeSlot, String excerciseType, String membershiptype, String membershipStartDate, String membershipEndDate, String istransPaid, String mon_attend, String tue_attend, String wed_attend) {
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.address = address;
        this.trainerName = trainerName;
        this.selectTimeSlot = selectTimeSlot;
        this.ExcerciseType = excerciseType;
        this.membershiptype = membershiptype;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.IstransPaid = istransPaid;
        this.mon_attend = mon_attend;
        this.tue_attend = tue_attend;
        this.wed_attend = wed_attend;
    }

    public ManageTraineeData() {
    }

    public ManageTraineeData(String name, String phno, String email, String address, String trainerName, String selectTimeSlot, String excerciseType, String membershiptype, String membershipStartDate, String membershipEndDate, String istransPaid) {
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.address = address;
        this.trainerName = trainerName;
        this.selectTimeSlot = selectTimeSlot;
        this.ExcerciseType = excerciseType;
        this.membershiptype = membershiptype;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.IstransPaid = istransPaid;
    }

    public String getMon_train() {
        return mon_train;
    }

    public void setMon_train(String mon_train) {
        this.mon_train = mon_train;
    }

    public String getTue_train() {
        return tue_train;
    }

    public void setTue_train(String tue_train) {
        this.tue_train = tue_train;
    }

    public String getWed_train() {
        return wed_train;
    }

    public void setWed_train(String wed_train) {
        this.wed_train = wed_train;
    }

    public String getMon_attend() {
        return mon_attend;
    }

    public void setMon_attend(String mon_attend) {
        this.mon_attend = mon_attend;
    }

    public String getTue_attend() {
        return tue_attend;
    }

    public void setTue_attend(String tue_attend) {
        this.tue_attend = tue_attend;
    }

    public String getWed_attend() {
        return wed_attend;
    }

    public void setWed_attend(String wed_attend) {
        this.wed_attend = wed_attend;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getSelectTimeSlot() {
        return selectTimeSlot;
    }

    public void setSelectTimeSlot(String selectTimeSlot) {
        this.selectTimeSlot = selectTimeSlot;
    }

    public String getExcerciseType() {
        return ExcerciseType;
    }

    public void setExcerciseType(String excerciseType) {
        ExcerciseType = excerciseType;
    }

    public String getMembershiptype() {
        return membershiptype;
    }

    public void setMembershiptype(String membershiptype) {
        this.membershiptype = membershiptype;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getMembershipEndDate() {
        return membershipEndDate;
    }

    public void setMembershipEndDate(String membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

    public String getIstransPaid() {
        return IstransPaid;
    }

    public void setIstransPaid(String istransPaid) {
        IstransPaid = istransPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phno;
    }

    public void setPhoneNo(String phno) {
        this.phno = phno;
    }

}
