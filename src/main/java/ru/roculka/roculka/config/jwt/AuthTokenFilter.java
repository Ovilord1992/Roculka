package ru.roculka.roculka.config.jwt;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import java.io.IOException;


public class AuthTokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}