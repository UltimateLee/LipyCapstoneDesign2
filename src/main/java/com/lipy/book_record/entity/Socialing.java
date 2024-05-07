package com.lipy.book_record.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    // 다대다 관계로 멤버와 연결
    @JsonIgnore
    @ManyToMany(mappedBy = "favoriteSocialings")
    private Set<Member> favoritedByMembers = new HashSet<>();

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
