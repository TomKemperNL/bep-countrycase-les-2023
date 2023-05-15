package nl.hu.bep.countrycase.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @GET
    public String hello(){
        return "Hello";
    }

    @GET
    @Path("doei")
    public String bye(){
        return "Doei";
    }
}
