package ca.springframework.sfgbankakar.services.jwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "2B4B6250655368566D597133743677397A244226452948404D635166546A576E"; // gizli anahtar olacak 250 byte altında

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject); // nedir?
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final  String username = extractUsername(token); // tokenın geçerliliği var mı kontrolu
       return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new java.util.Date());
    }

    private java.util.Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration); // Claims::getExpiration? // bitiş tarihi
    }

    public String generateToken(Map<String,Object> extractClaims, UserDetails userDetails){
        //token üretme yeri
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())) // Token oluşturma tarih
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // Token bitiş tarihi
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // imzalama yolu
        .compact();

    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
         final  Claims claims = extractAllClaims(token);
         return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())  // imzalama anahtarı
                .build()
                .parseClaimsJws(token) // token ayrıştıracağız
                .getBody();
    }

    private Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // hex lenmiş 256 bit keyi decode ederek çözelim
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
