package nl.hu.bep.countrycase;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;

public class TestMetJwts {
    public static void main(String[] args) {

        SecretKeySpec key = new SecretKeySpec("mijngeheimewachtwoord".getBytes(), SignatureAlgorithm.HS512.getJcaName());
        SecretKeySpec gehackteSleutel = new SecretKeySpec("ietsheelanders".getBytes(), SignatureAlgorithm.HS512.getJcaName());

        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, gehackteSleutel)
                .setSubject("Tom")
                .compact();

        System.out.println(token);


        String username = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody().getSubject();

        System.out.println(username);



    }

}
