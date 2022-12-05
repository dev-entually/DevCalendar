package com.deventually.devcallendar.postings.presentation;

import com.deventually.devcallendar.context.RequestContext;
import com.deventually.devcallendar.postings.application.PostingDeleteService;
import com.deventually.devcallendar.postings.dto.SuccessPostingResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostingDeleteController {

    private final PostingDeleteService postingDeleteService;

    public PostingDeleteController(PostingDeleteService postingDeleteService) {
        this.postingDeleteService = postingDeleteService;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/postings/{postingKey}")
    public SuccessPostingResponseDto delete(
            @PathVariable Long postingKey,
            RequestContext requestContext
    ) {

        return new SuccessPostingResponseDto(
                postingDeleteService.delete(postingKey),
                requestContext.getSupportLang().code,
                requestContext.getZoneId().getId()
        );
    }
}


