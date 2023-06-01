package nl.hu.bep.countrycase.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.hu.bep.countrycase.TestMetJwts;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(LoginRequest loginReq){
        String username = loginReq.getUser();
        String password = loginReq.getPassword();

        if(password.equals("wachtwoord")){

            String token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS512, TestMetJwts.key)
                    .setSubject(username)
                    .compact();

            return Response.ok(new LoginReply(token)).build();
        }else{
            return Response.status(401).build();
        }
    }
}
