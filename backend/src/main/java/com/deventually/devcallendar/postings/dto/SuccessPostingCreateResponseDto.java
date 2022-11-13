package com.deventually.devcallendar.postings.dto;

public class SuccessPostingCreateResponseDto {
    private String message = "Your request was successfully processed.";
    private String status = "success";
    private String responseZoneId = "Asia/Seoul";
    private String responseLanguage = "ko";
    private PostingRetrieveDto result;

    public SuccessPostingCreateResponseDto(PostingRetrieveDto result) {
        this.result = result;
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
