package com.lipy.book_record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;


@Entity
@Setter
public class SociallingApplication {
    @Id
    private Long Id;

    @Column
    private Long sociallingId;

    @Column
    private Long applicantId;

    private String status; // "Pending", "Accepted", "Rejected"
}
