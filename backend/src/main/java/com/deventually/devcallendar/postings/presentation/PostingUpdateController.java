package com.deventually.devcallendar.postings.presentation;

import com.deventually.devcallendar.context.RequestContext;
import com.deventually.devcallendar.postings.application.PostingUpdateService;
import com.deventually.devcallendar.postings.dto.PostingUpdateRequestDto;
import com.deventually.devcallendar.postings.dto.SuccessPostingResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostingUpdateController {

    private final PostingUpdateService postingUpdateService;

    public PostingUpdateController(PostingUpdateService postingUpdateService) {
        this.postingUpdateService = postingUpdateService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/postings/{postingKey}")
    public SuccessPostingResponseDto update(
            @PathVariable Long postingKey,
            @RequestBody @Valid PostingUpdateRequestDto postingUpdateRequestDto,
            RequestContext requestContext
    ) {

        return new SuccessPostingResponseDto(
                postingUpdateService.update(postingKey, postingUpdateRequestDto),
                requestContext.getSupportLang().code,
                requestContext.getZoneId().getId()
        );
    }
}


