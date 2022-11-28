package com.deventually.devcallendar.postings.dto;

public class SuccessPostingResponseDto {
    private final String responseZoneId;
    private final String responseLanguage;
    private final PostingRetrieveDto result;
    private final String message = "Your request was successfully processed.";
    private final String status = "success";

    public SuccessPostingResponseDto(
            PostingRetrieveDto result,
            String responseLanguage,
            String responseZoneId
    ) {
        this.result = result;
        this.responseLanguage = responseLanguage;
        this.responseZoneId = responseZoneId;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getResponseZoneId() {
        return responseZoneId;
    }

    public String getResponseLanguage() {
        return responseLanguage;
    }

    public PostingRetrieveDto getResult() {
        return result;
    }
}
