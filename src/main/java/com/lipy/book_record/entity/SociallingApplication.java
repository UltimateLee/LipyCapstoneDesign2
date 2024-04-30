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

    @Column
    private int maxNum; // 최대인원

    @Column
    private int curNum; // 현재인원

    private String status; // "Pending", "Accepted", "Rejected"

    //== 수강 인원 확인 ==//
    public boolean isFull() {
        return curNum >= maxNum;
    }
}
