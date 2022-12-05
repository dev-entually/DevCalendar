package com.deventually.devcallendar.postings.application;

import com.deventually.devcallendar.postings.domain.Posting;
import com.deventually.devcallendar.postings.domain.PostingRepository;
import com.deventually.devcallendar.postings.dto.PostingRetrieveDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostingDeleteService {

    private final PostingRepository postingRepository;

    public PostingDeleteService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    @Transactional
    public PostingRetrieveDto delete(Long postingKey) {
        Posting posting = postingRepository.findById(postingKey)
                                           .orElseThrow(() -> new RuntimeException(String.format("no key=%d posting", postingKey)));
        postingRepository.delete(posting);
        return posting.toRetrieveDto();
    }

}
