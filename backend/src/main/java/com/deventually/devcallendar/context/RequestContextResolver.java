package com.deventually.devcallendar.context;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Component
public class RequestContextResolver implements HandlerMethodArgumentResolver {
    private final LocaleResolver localeResolver;

    public RequestContextResolver(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(RequestContext.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory){
        HttpServletRequest req = (HttpServletRequest) webRequest.getNativeRequest();
        Locale locale = localeResolver.resolveLocale(req);

        RequestContext requestContext = new RequestContext(SupportLang.from(locale));
        RequestContextHolder.set(requestContext);

        return requestContext;
    }
}
