package com.turkcell.pair3.core.annotations;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal // Principal is set to username fetched from JWT
public @interface CurrentUsername {}
