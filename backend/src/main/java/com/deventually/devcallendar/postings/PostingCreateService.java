package com.deventually.devcallendar.postings;

import com.deventually.devcallendar.postings.dto.Career;
import com.deventually.devcallendar.postings.dto.Job;
import com.deventually.devcallendar.postings.dto.PostingCreateRequestDto;
import com.deventually.devcallendar.postings.dto.PostingRetrieveDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
