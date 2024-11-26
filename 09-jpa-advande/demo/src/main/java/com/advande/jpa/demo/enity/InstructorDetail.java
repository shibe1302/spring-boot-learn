package com.advande.jpa.demo.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name="youtube_channel")
    private String yotubeChanel;

    @Column(name="hobby")
    private String hobby;

    public InstructorDetail() {
    }

    public InstructorDetail(String yotubeChanel, String hobby) {
        this.yotubeChanel = yotubeChanel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYotubeChanel() {
        return yotubeChanel;
    }

    public void setYotubeChanel(String yotubeChanel) {
        this.yotubeChanel = yotubeChanel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", yotubeChanel=" + yotubeChanel + ", hobby=" + hobby + "]";
    }

    

}
