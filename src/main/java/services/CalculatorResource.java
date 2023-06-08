

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
    public Response telOp(TelopRequest input) {
        return Response.ok(new TelopResponse(input.getal1 + input.getal2)).build();
    }

    public static class TelopRequest {
        public int getal1;
        public int getal2;
    }

    public static class TelopResponse {
        public int resultaat;

        public TelopResponse(int resultaat) {
            this.resultaat = resultaat;
        }

    }


}

