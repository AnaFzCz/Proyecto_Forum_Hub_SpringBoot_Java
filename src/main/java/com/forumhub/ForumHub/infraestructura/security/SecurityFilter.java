package com.forumhub.ForumHub.infraestructura.security;

import com.forumhub.ForumHub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // System.out.printf("FILTRO......");
        try {
            //  System.out.println("FILTRO LLAMADO");
            var tokenJWT = recuperarToken(request);
            System.out.println(tokenJWT);
            if (tokenJWT != null) {
                var subject = tokenService.getSubject(tokenJWT);
                System.out.println(subject);
                var usuario = repository.findByEmail(subject);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                //  System.out.println("logado");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {

            return authorizationHeader.replace("Bearer ", "").trim();

        }
        return null;
    }

}
