package com.deventually.devcallendar.postings.domain;

import com.deventually.devcallendar.postings.dto.PostingCreateRequestDto;
import com.deventually.devcallendar.postings.dto.PostingRetrieveDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSTING_ID", nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "START_DATE_TIME")
    private LocalDateTime startDateTime;
    @Column(name = "END_DATE_TIME")
    private LocalDateTime endDateTime;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "CAREERS")
    private List<Career> careers;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "JOBS")
    private List<Job> jobs;

    protected Posting() {
    }

    public Posting(String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String description,
                   String companyName, List<Career> careers, List<Job> jobs) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.description = description;
        this.companyName = companyName;
        this.careers = careers;
        this.jobs = jobs;
    }

    public static Posting of(PostingCreateRequestDto dto) {
        return new Posting(
                dto.getTitle(),
                dto.getStartDateTime(),
                dto.getEndDateTime(),
                dto.getDescription(),
                dto.getCompanyName(),
                dto.getCareers(),
                dto.getJobs()
        );
    }

    public void update(
            String title,
            String description,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            String companyName,
            List<Career> careers,
            List<Job> jobs
    ) {
        if (
                Objects.equals(this.title, title)
                        && Objects.equals(this.description, description)
                        && Objects.equals(this.startDateTime, startDateTime)
                        && Objects.equals(this.endDateTime, endDateTime)
                        && Objects.equals(this.companyName, companyName)
                        && Objects.equals(this.careers, careers)
                        && Objects.equals(this.jobs, jobs)
        ) {
            return;
        }
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.companyName = companyName;
        this.careers = careers;
        this.jobs = jobs;
    }

    public PostingRetrieveDto toRetrieveDto() {
        return new PostingRetrieveDto(
                this.id,
                this.title,
                this.startDateTime,
                this.endDateTime,
                this.description,
                this.companyName,
                this.careers,
                this.jobs
        );
    }
}
