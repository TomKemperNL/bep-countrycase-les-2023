package nl.hu.bep.countrycase.security;

import java.security.Principal;

public class CountryPrincipal implements Principal {
    private String name;

    public CountryPrincipal(String nm) {
        this.name = nm;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
