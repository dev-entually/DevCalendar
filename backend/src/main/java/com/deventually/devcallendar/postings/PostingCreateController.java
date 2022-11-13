package com.deventually.devcallendar.postings;

import com.deventually.devcallendar.postings.dto.PostingCreateRequestDto;
import com.deventually.devcallendar.postings.dto.SuccessPostingCreateResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PostingCreateController {

    private final PostingCreateService postingCreateService;

    public PostingCreateController(PostingCreateService postingCreateService) {
        this.postingCreateService = postingCreateService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/postings")
    public SuccessPostingCreateResponseDto create(
            @RequestBody @Valid PostingCreateRequestDto postingCreateRequestDto
    ) {
        return new SuccessPostingCreateResponseDto(
                postingCreateService.create(postingCreateRequestDto)
        );
    }
}


