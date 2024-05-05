package com.lipy.book_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Socialing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String writer;
    private String content;
    private int maxparticipants; // 최대 참여자 수
    private int currentparticipants; // 현재 참여자 수
    private Date date;

    //private String status; // "Pending", "Accepted", "Rejected"

    public void update(String title, String description,String content,int maxParticipants, Date date) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.maxparticipants = maxParticipants;
        this.date = date;
    }

    //== 소셜링 인원 확인 ==//
    public boolean isFull() {
        return currentparticipants >= maxparticipants;
    }

    //== 소셜링 인원 증가 ==
    public void increaseParticipants() {
        currentparticipants++;
    }
}
