package com.deventually.devcallendar.postings.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostingRetrieveDto {
    private Long postingKey;
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String description;
    private String companyName;
    private List<Career> careers;
    private List<Job> jobs;

    public PostingRetrieveDto(Long postingKey, String title, LocalDateTime startDateTime, LocalDateTime endDateTime,
                              String description, String companyName, List<Career> careers, List<Job> jobs) {
        this.postingKey = postingKey;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.description = description;
        this.companyName = companyName;
        this.careers = careers;
        this.jobs = jobs;
    }

    public Long getPostingKey() {
        return postingKey;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
