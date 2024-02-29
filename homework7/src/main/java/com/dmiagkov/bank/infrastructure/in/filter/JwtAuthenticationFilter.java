package com.dmiagkov.bank.infrastructure.in.filter;

import com.dmiagkov.bank.security.JwtProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String USER_ID = "userId";
    private final ObjectMapper mapper = new ObjectMapper();
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;
    private final Map<String, String> errorDetails = new HashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String accessToken = jwtProvider.resolveToken(request);
            if (accessToken == null) {
                filterChain.doFilter(request, response);
                return;
            }
            Claims claims = jwtProvider.resolveClaims(request);
            if (claims != null && jwtProvider.validateClaims(claims)) {
                Long userId = claims.get(USER_ID, Long.class);
                request.setAttribute(USER_ID, userId);

                String login = claims.getSubject();
                UserDetails userDetails = userDetailsService.loadUserByUsername(login);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(login, "", userDetails.getAuthorities());
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(authentication);
                SecurityContextHolder.setContext(context);
            }
        } catch (Exception e) {
            log.error("EXCEPTION OCCURRED: ", e);
            handleByJson(response, e);
        }
        filterChain.doFilter(request, response);
    }

    private void handleByJson(HttpServletResponse response, Exception e) throws IOException {
        errorDetails.put("message", "Authentication Error");
        errorDetails.put("details", e.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), errorDetails);
    }
}
