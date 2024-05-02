package com.lipy.book_record.controller;

import com.lipy.book_record.entity.Socialing;
import com.lipy.book_record.service.SocialingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialingController {

    private final SocialingService socialingService;

    @Autowired
    public SocialingController(SocialingService socialingService) {
        this.socialingService = socialingService;
    }

    @PostMapping("/apply/{socialingId}")
    public ResponseEntity<Socialing> applyForSocialing(@PathVariable Long socialingId) {
        // 소셜링 신청 처리
        Socialing appliedSocialing = socialingService.applyForSocialing(socialingId);
        return ResponseEntity.ok(appliedSocialing);
    }
}