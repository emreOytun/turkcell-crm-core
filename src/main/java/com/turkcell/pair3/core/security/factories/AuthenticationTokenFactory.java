package com.turkcell.pair3.core.security.factories;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationTokenFactory {
    public static UsernamePasswordAuthenticationToken createWithUsernamePassword(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
