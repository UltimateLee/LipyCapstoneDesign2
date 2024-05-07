package com.lipy.book_record.service;

import com.lipy.book_record.dto.SocialingListResponse;
import com.lipy.book_record.entity.Member;
import com.lipy.book_record.entity.Socialing;
import com.lipy.book_record.repository.MemberRepository;
import com.lipy.book_record.repository.SocialingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SocialingRepository socialingRepository;

    public List<SocialingListResponse> getFavoriteSocialings(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberId));
        Set<Socialing> favoriteSocialings = member.getFavoriteSocialings();
        return favoriteSocialings.stream()
                .map(socialing -> {
                    SocialingListResponse dto = new SocialingListResponse();
                    dto.setTitle(socialing.getTitle());
                    dto.setDescription(socialing.getDescription());
                    dto.setWriter(socialing.getWriter());
                    dto.setCurrentparticipants(socialing.getCurrentparticipants());
                    dto.setMaxparticipants(socialing.getMaxparticipants());
                    dto.setDate(socialing.getDate());
                    return dto;
                })
                .toList();
    }

//    public Set<Socialing> getFavoriteSocialings(Long memberId) {
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
//        return member.getFavoriteSocialings();
//    }

    public void addFavoriteSocialing(Long memberId, Long socialingId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));

        Socialing socialing = socialingRepository.findById(socialingId)
                .orElseThrow(() -> new IllegalArgumentException("Socialing not found with id: " + socialingId));

        // 멤버의 즐겨찾기에 소셜링 추가
        member.getFavoriteSocialings().add(socialing);
        memberRepository.save(member);
    }
}
