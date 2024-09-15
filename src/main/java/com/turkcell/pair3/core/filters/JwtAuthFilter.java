package com.turkcell.pair3.core.filters;

import com.turkcell.pair3.core.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final Logger logger = LogManager.getLogger(JwtAuthFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String logMessage = null;
            String jwtHeader = request.getHeader("Authorization");

            if (validateJwtHeader(jwtHeader)) {
                String jwt = jwtHeader.substring(7);
                String username = jwtService.extractUsername(jwt);
                List<String> roles = jwtService.extractRoles(jwt);
                List<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList();

                UsernamePasswordAuthenticationToken token = new
                        UsernamePasswordAuthenticationToken(username, null, authorities);
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token);
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error(e, e);
            logger.error("Request cannot be authenticated. exception: " + e);
        }
    }

    private boolean validateJwtHeader(String jwtHeader) {
        if (jwtHeader == null || !jwtHeader.startsWith("Bearer ")) {
            logger.info("JWT Token is null or it does not start with Bearer. JwtHeader: " + jwtHeader);
            return false;
        }

        String jwt = jwtHeader.substring(7);
        String username = jwtService.extractUsername(jwt);

        if (!jwtService.validateToken(jwt, username)) {
            logger.info("JWT Token cannot be validated. Token: " + jwt);
            return false;
        }
        return true;
    }
}