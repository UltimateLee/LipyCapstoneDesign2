package com.lipy.book_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Socialing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int maxparticipants; // 최대 참여자 수
    private int currentparticipants; // 현재 참여자 수
    private String date;

    //private String status; // "Pending", "Accepted", "Rejected"

    public Socialing() {

    }

    public Socialing(String title, String description, int maxParticipants, String date) {
        this.title = title;
        this.description = description;
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
