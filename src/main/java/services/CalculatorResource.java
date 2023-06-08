

package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("calculator")
public class CalculatorResource {

    @POST
    @Path("/telop")
    @Produces("application/json")
    @Consumes("application/json")
    public Response telOp(TelopRequest input){
        int getal1 = input.getGetal1();
        int getal2 = input.getGetal2();
        int resultaat = getal1 + getal2;
        return Response.ok(new TelopResponse(resultaat)).build();
    }
}

