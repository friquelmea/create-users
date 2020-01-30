package cl.globallogic.friquelme.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
  private static final long EXPIRATIONTIME = 600_000; // 30 minutos
  private static final String SECRET = "FriquelmeGloballogic";
  private static final String TOKEN_PREFIX = "Bearer ";
  private static final String HEADER_STRING = "Authorization";

  public static void addAuthentication(HttpServletResponse res, String username) {
    String JWT = Jwts.builder()
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, SECRET)
        .compact();
    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
  }
  
  public static Date getExpirationDateFromToken(String token) {
	  Date date = Jwts.parser()         
      .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
      .parseClaimsJws(token).getBody().getExpiration();
	  return date;
  }
}