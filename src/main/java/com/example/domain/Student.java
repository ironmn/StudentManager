package com.example.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private String sno;
    private String sname;
    private String clasno;
    private String phone;
    private String address;
    private Clas clas;
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getClasno() {
        return clasno;
    }

    public void setClasno(String clasno) {
        this.clasno = clasno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Clas getClas() {
        return clas;
    }

    public void setClas(Clas clas) {
        this.clas = clas;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", clasno='" + clasno + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", clas=" + clas +
                '}';
    }
}
