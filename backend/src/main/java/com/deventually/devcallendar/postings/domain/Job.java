package com.deventually.devcallendar.postings.domain;

public enum Job {
    IOS("ios"),
    AOS("aos"),
    FE("fe"),
    BE("be");

    public final String job;

    Job(String job) {
        this.job = job;
    }
}
