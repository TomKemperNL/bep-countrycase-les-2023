package nl.hu.bep.countrycase.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountrySecurityContextTest {

    @Test
    void isBobEenAdmin() {
        CountrySecurityContext context = new CountrySecurityContext(new CountryPrincipal("Bob"));
        assertTrue(context.isUserInRole("admin"));

    }

    @Test
    void isTomGeenAdmin() {
        CountrySecurityContext context = new CountrySecurityContext(new CountryPrincipal("Tom"));
        assertFalse(context.isUserInRole("admin"));
    }

    @Test
    void niemandIsGeenAdmin() {
        CountrySecurityContext context = new CountrySecurityContext(null);
        assertFalse(context.isUserInRole("admin"));
    }

}