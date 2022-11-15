package com.deventually.devcallendar.context;

import java.time.ZoneId;

public class RequestContext {
    private final SupportLang supportLang;
    private final ZoneId zoneId;

    public RequestContext(SupportLang supportLang, ZoneId zoneId) {
        this.supportLang = supportLang;
        this.zoneId = zoneId;
    }

    public SupportLang getSupportLang() {
        return supportLang;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }
}
