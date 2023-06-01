package nl.hu.bep.countrycase.webservices;


import nl.hu.bep.countrycase.model.Country;
import nl.hu.bep.countrycase.model.World;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("countries")
public class WorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountries() throws InterruptedException {
//        Thread.sleep(5000);
        return World.getWorld().getAllCountries();
    }

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountry(@PathParam("code") String code) {
        return World.getWorld().getCountryByCode(code);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Country newCountry(CountryPostRequest req){
        Country c = new Country(
                req.getCode(),
                req.getIso3(),
                req.getName(),
                "","", "", 42,33,"",17,19);

        World.getWorld().addCountry(c);

        return c;
    }


}
