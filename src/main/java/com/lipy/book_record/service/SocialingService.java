package com.lipy.book_record.service;

import com.lipy.book_record.entity.Socialing;
import com.lipy.book_record.repository.SocialingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialingService {

    private final SocialingRepository socialingRepository;

    @Autowired
    public SocialingService(SocialingRepository socialingRepository) {
        this.socialingRepository = socialingRepository;
    }

    public Socialing applyForSocialing(Long socialingId) {
        Socialing socialing = socialingRepository.findById(socialingId)
                .orElseThrow(() -> new RuntimeException("소셜링을 찾을 수 없습니다."));
        if (!socialing.isFull()) {
            socialing.increaseParticipants(); // 현재 참여자 수 증가
            return socialingRepository.save(socialing);
        } else {
            throw new RuntimeException("소셜링의 최대 참여자 수를 초과했습니다.");
        }
    }
}


