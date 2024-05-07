package com.lipy.book_record.controller;

import com.lipy.book_record.dto.SocialingListResponse;
import com.lipy.book_record.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/socialing/{socialingId}/interest/{memberId}")
    public ResponseEntity<?> addFavoriteSocialing(@PathVariable Long memberId, @PathVariable Long socialingId) {
        memberService.addFavoriteSocialing(memberId, socialingId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/socialing/interest/{memberId}")
    public ResponseEntity<List<SocialingListResponse>> getFavoriteSocialings(@PathVariable Long memberId) {
        List<SocialingListResponse> favoriteSocialings = memberService.getFavoriteSocialings(memberId);
        return ResponseEntity.ok().body(favoriteSocialings);
    }

}
