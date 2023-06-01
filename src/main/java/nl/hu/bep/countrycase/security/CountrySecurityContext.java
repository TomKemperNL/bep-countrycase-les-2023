package nl.hu.bep.countrycase.security;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class CountrySecurityContext implements SecurityContext {

    private CountryPrincipal principal;

    public CountrySecurityContext(CountryPrincipal principal){
        this.principal = principal;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}
