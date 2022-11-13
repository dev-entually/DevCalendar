package com.deventually.devcallendar.context;

public class RequestContextHolder {
    private static final ThreadLocal<RequestContext> LOCAL = new ThreadLocal<>();

    public static SupportLang getSupportLang() {
        RequestContext requestContext = LOCAL.get();
        if (requestContext == null) {
            return SupportLang.KO;
        }
        return requestContext.getSupportLang();
    }

    public static void remove() {
        LOCAL.remove();
    }

    public static void set(RequestContext requestContext) {
        LOCAL.set(requestContext);
    }
}
