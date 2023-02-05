package ca.springframework.sfgbankakar.jwt;

import ca.springframework.sfgbankakar.services.jwtService.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Bu filter her bir request de aktif olmasını istiyoruz
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final UserDetailsService userDetailsService;

    /*@RequiredArgsConstructor: Class içinde final ve NonNull olan değişkenleri parametre olarak alan bir constructor oluşturur.*/

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
              final String authHeader = request.getHeader("Authorization");
              final String jwt;
              final String username;
              if(authHeader == null|| !authHeader.startsWith("Bearer") ){
                  filterChain.doFilter(request,response); // client tarafından header bilgisi olarak Bearer yok ise  return edeceğiz direk
                  // amacımız token istemek
                  return;
              }
              jwt = authHeader.substring(7); // Bearer den sonrasını alır oda tokendir;
              username = jwtService.extractUsername(jwt);
              if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null){
                  // SecurityContextHolder.getContext().getAuthentication() == null ise henüz kullanıcı doğrulanmamış
                  UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                  if(jwtService.isTokenValid(jwt,userDetails)){
                      UsernamePasswordAuthenticationToken authToken =
                              new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                      authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                      SecurityContextHolder.getContext().setAuthentication(authToken); // kullanıcı doğrulanmış auth context ekleyelim
                  }
              }
              filterChain.doFilter(request,response); // her zaman filter geçmesini istiyorsak
    }
}
