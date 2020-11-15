package com.example.domain;

import java.io.Serializable;

public class Depart implements Serializable {
    private String departno;
    private String departname;

    public String getDepartno() {
        return departno;
    }

    public void setDepartno(String departno) {
        this.departno = departno;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "departno='" + departno + '\'' +
                ", departname='" + departname + '\'' +
                '}';
    }
}
