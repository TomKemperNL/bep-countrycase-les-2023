package nl.hu.bep.countrycase;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TestMetJwts {

    public static SecretKeySpec key = new SecretKeySpec("mijngeheimewachtwoord".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    private Key key2 = MacProvider.generateKey();

    public static void main(String[] args) {

        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, key)
                .setSubject("Tom")
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(50).toInstant(ZoneOffset.UTC)))
                .compact();

        System.out.println(token);


        var jwt = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token);

        String username = jwt.getBody().getSubject();

        System.out.println(username);



    }

}
