package com.navas.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String jwt = extractTokenFromHeader(request, response, filterChain);

        final String userEmail = jwtService.extractUsername(jwt);
        boolean userNotConnected = SecurityContextHolder.getContext().getAuthentication() == null;
        if (userEmail != null && userNotConnected) {
            UsernamePasswordAuthenticationToken authToken = validateJwt(request, jwt, userEmail);
            updateSecurityContextHolder(authToken);
        }
        filterChain.doFilter(request, response);
    }

    private static void updateSecurityContextHolder(UsernamePasswordAuthenticationToken authToken) {
        if (authToken != null) {
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

    private UsernamePasswordAuthenticationToken validateJwt(HttpServletRequest request, String jwt, String userEmail) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        if (jwtService.isTokenValid(jwt, userDetails)) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );
            authToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            return authToken;
        }
        return null;
    }

    private static String extractTokenFromHeader(HttpServletRequest request, HttpServletResponse response,
                                                 FilterChain filterChain) throws IOException, ServletException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String bearerName = "Bearer ";
        final String username;
        if (authHeader == null || !authHeader.startsWith(bearerName)) {
            filterChain.doFilter(request, response);
        }
        jwt = authHeader.substring(bearerName.length());
        return jwt;
    }
}