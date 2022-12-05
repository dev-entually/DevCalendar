package com.deventually.devcallendar.postings.dto;

import com.deventually.devcallendar.postings.domain.Career;
import com.deventually.devcallendar.postings.domain.Job;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class PostingUpdateRequestDto {

    @NotBlank
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String description;
    @NotBlank
    private String companyName;
    private List<Career> careers;
    private List<Job> jobs;

    public String getTitle() {
        return this.title;
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
