package com.lipy.book_record.service;

import com.lipy.book_record.dto.UpdateSocialingRequest;
import com.lipy.book_record.entity.Socialing;
import com.lipy.book_record.repository.SocialingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SocialingService {
    private final SocialingRepository socialingRepository;

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
    @Transactional
    public Socialing update(long id, UpdateSocialingRequest request){
        Socialing socialing = socialingRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found:" + id));

        if(request.getTitle() != null){
            socialing.setTitle(request.getTitle());
        }
        if(request.getDescription() != null){
            socialing.setDescription(request.getDescription());
        }
        if(request.getContent() != null){
            socialing.setContent(request.getContent());
        }

        int maxParticipants = request.getMaxparticipants();
        socialing.setMaxparticipants(maxParticipants);

        if(request.getDate() != null){
            socialing.setDate(request.getDate());
        }

        return socialingRepository.save(socialing);
    }


    public Socialing findById(long id){
        return socialingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("not found:" + id)));
    }

    public Socialing createSocialingPost(Socialing socialing) { // 게시글 생성
        return socialingRepository.save(socialing);
    }

    public List<Socialing> findAllOrderByCurrentParticipants() {
        return socialingRepository.findAllByOrderByCurrentparticipantsAsc();
    }
    public List<Socialing> findAllSocialings() { // 게시글 목록 조회
        return socialingRepository.findAll();
    }
    public void deleteForSocialing(Long socialingId) { // 게시글 삭제
        socialingRepository.deleteById(socialingId);
    }
}


