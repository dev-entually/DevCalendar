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
    public PostingRetrieveDto create(PostingCreateRequestDto postingCreateRequestDto) {
        List<Career> careers = new ArrayList<>();
        List<Job> jobs = new ArrayList<>();
        careers.add(Career.NEW);
        return new PostingRetrieveDto(
                123L,
                "title",
                LocalDateTime.now(),
                null,
                "desc",
                "company",
                careers, jobs);
    }
}
