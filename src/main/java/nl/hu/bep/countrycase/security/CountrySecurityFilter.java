package nl.hu.bep.countrycase.security;

import io.jsonwebtoken.Jwts;
import nl.hu.bep.countrycase.TestMetJwts;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class CountrySecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("Ik zit op elk request");

        String authheader = requestContext.getHeaderString("Authorization");

        if (authheader != null) {

            String token = authheader.replace("Bearer ", "");

            String user = Jwts.parser()
                    .setSigningKey(TestMetJwts.key)
                    .parseClaimsJws(token)
                    .getBody().getSubject();

            if (user != null) {
                CountryPrincipal principal = new CountryPrincipal(user);
                SecurityContext context = new CountrySecurityContext(principal);

                requestContext.setSecurityContext(context);
            }
        }
    }
}
