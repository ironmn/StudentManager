package com.example.domain;

import java.io.Serializable;

public class Clas implements Serializable {
    private String clasno;
    private String clasname;
    private String departno;
    private Depart depart;
    public String getClasno() {
        return clasno;
    }

    public void setClasno(String clasno) {
        this.clasno = clasno;
    }

    public String getClasname() {
        return clasname;
    }

    public void setClasname(String clasname) {
        this.clasname = clasname;
    }

    public String getDepartno() {
        return departno;
    }

    public void setDepartno(String departno) {
        this.departno = departno;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Clas{" +
                "clasno='" + clasno + '\'' +
                ", clasname='" + clasname + '\'' +
                ", departno='" + departno + '\'' +
                ", depart=" + depart +
                '}';
    }
}
