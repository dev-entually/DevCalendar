package com.deventually.devcallendar.context;

public class RequestContext {
    private final SupportLang supportLang;

    public RequestContext(SupportLang supportLang) {
        this.supportLang = supportLang;
    }

    public SupportLang getSupportLang() {
        return supportLang;
    }
}
