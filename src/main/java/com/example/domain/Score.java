package com.example.domain;

import java.io.Serializable;

public class Score implements Serializable {
    private String sno;
    private String cno;
    private Float score;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", score=" + score +
                '}';
    }
}
