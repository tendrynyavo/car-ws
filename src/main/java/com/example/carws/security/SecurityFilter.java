package com.example.carws.security;

import io.jsonwebtoken.Claims;
// import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.List;

import com.example.carws.model.token.Token;
import com.example.carws.model.users.Role;
import com.example.carws.model.users.Users;
import com.example.carws.service.UsersService;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    UsersService usersService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        verifyToken(request);
        filterChain.doFilter(request, response);
    }

    private void verifyToken(HttpServletRequest request)  {
        String token = this.getBearerToken(request);
        // System.out.println("The big token is ==> " + token);
        try {
            Users user = new Token().getUser(token);
            if(user != null) {
                UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(user.getMail())
                    .password(user.getPassword())
                    .authorities(user.getAuthorities()) 
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getId(), null, userDetails.getAuthorities()); 
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("Efa ato ve enaooo???");
            }
        } catch (Exception e) {
            System.out.println("Filter Error: " + e.getMessage());
        }
    }

    public String getBearerToken(HttpServletRequest request) {
        String bearerToken = null;
        String authorization = request.getHeader("Authorization");
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            bearerToken = authorization.substring(7);
        }
        return bearerToken;
    }

}
