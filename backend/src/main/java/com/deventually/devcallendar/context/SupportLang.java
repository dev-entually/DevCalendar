package com.deventually.devcallendar.context;

import java.util.Arrays;
import java.util.Locale;

public enum SupportLang {
    KO(Locale.KOREAN, "ko"), EN(Locale.ENGLISH, "en");

    public final Locale locale;
    public final String code;

    SupportLang(Locale locale, String code) {
        this.locale = locale;
        this.code = code;
    }

    public static SupportLang of(Locale locale) {
        return Arrays.stream(values()).filter(it -> it.locale == locale).findFirst().orElse(KO);
    }
}
