package com.deventually.devcallendar.postings.presentation;

import com.deventually.devcallendar.context.RequestContext;
import com.deventually.devcallendar.postings.application.PostingCreateService;
import com.deventually.devcallendar.postings.dto.PostingCreateRequestDto;
import com.deventually.devcallendar.postings.dto.SuccessPostingResponseDto;
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
    public SuccessPostingResponseDto create(
            @RequestBody @Valid PostingCreateRequestDto postingCreateRequestDto,
            RequestContext requestContext
    ) {

        return new SuccessPostingResponseDto(
                postingCreateService.create(postingCreateRequestDto),
                requestContext.getSupportLang().code,
                requestContext.getZoneId().getId()
        );
    }
}


