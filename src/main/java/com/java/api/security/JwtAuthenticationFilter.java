package com.java.api.security;

import com.mysql.cj.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwtToken=extractJwtFromRequest(request);
            Long id=jwtTokenProvider.getUserIdFromJwt(jwtToken);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearer=request.getHeader("Authorization");
        if(StringUtils.hasWildcards(bearer)&& bearer.startsWith("Bearer"))
        return bearer.substring("Bearer".length()+1);
        return null;
    }
}
