package com.deventually.devcallendar.postings.application;

import com.deventually.devcallendar.postings.domain.Posting;
import com.deventually.devcallendar.postings.domain.PostingRepository;
import com.deventually.devcallendar.postings.dto.PostingCreateRequestDto;
import com.deventually.devcallendar.postings.dto.PostingRetrieveDto;
import org.springframework.stereotype.Service;

@Service
public class PostingCreateService {

    private final PostingRepository postingRepository;

    public PostingCreateService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public PostingRetrieveDto create(PostingCreateRequestDto postingCreateRequestDto) {
        Posting posting = postingRepository.save(Posting.of(postingCreateRequestDto));
        return posting.toRetrieveDto();
    }

}
