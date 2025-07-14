package com.school;

public class Course{
    int Cid;
    String Cname;
    public void setter(int Cid, String Cname) {
        this.Cid = Cid;
        this.Cname = Cname;
    }
    public void display() {
        System.out.println("COURSE ID: " + Cid +" "+"Name: " + Cname);
       
    }
    
}
