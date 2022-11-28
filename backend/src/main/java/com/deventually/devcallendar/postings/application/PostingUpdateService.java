package com.deventually.devcallendar.postings.application;

import com.deventually.devcallendar.postings.domain.Posting;
import com.deventually.devcallendar.postings.domain.PostingRepository;
import com.deventually.devcallendar.postings.dto.PostingRetrieveDto;
import com.deventually.devcallendar.postings.dto.PostingUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostingUpdateService {

    private final PostingRepository postingRepository;

    public PostingUpdateService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    @Transactional
    public PostingRetrieveDto update(Long postingKey, PostingUpdateRequestDto postingUpdateRequestDto) {
        Posting posting = postingRepository.findById(postingKey)
                                           .orElseThrow(() -> new RuntimeException(String.format("no key=%d posting", postingKey)));
        posting.update(
                postingUpdateRequestDto.getTitle(),
                postingUpdateRequestDto.getDescription(),
                postingUpdateRequestDto.getStartDateTime(),
                postingUpdateRequestDto.getEndDateTime(),
                postingUpdateRequestDto.getCompanyName(),
                postingUpdateRequestDto.getCareers(),
                postingUpdateRequestDto.getJobs()
        );

        return posting.toRetrieveDto();
    }

}
