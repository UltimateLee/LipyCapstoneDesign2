package com.lipy.book_record.dto;

import com.lipy.book_record.entity.Socialing;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class SocialingListResponse {
    private String title;
    private String description;
    private String writer;
    private int currentparticipants;
    private int maxparticipants;
    private Date date;

    public SocialingListResponse(Socialing socialing){
        this.title = socialing.getTitle();
        this.description = socialing.getDescription();
        this.writer = socialing.getWriter();
        this.currentparticipants = socialing.getCurrentparticipants();
        this.maxparticipants = socialing.getMaxparticipants();
        this.date = socialing.getDate();
    }

    public SocialingListResponse() {

    }


}

