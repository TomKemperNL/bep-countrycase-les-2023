package nl.hu.bep.countrycase.security;

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

        CountryPrincipal principal = new CountryPrincipal("Bob");
        SecurityContext context = new CountrySecurityContext(principal);

        requestContext.setSecurityContext(context);
    }
}
