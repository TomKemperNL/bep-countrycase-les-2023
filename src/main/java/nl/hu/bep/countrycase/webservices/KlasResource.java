package nl.hu.bep.countrycase.webservices;

import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.util.List;

@Path("/klas")
public class KlasResource {

    private Klas klas = Klas.getKlas();

    @GET
    @Produces("application/json")
    public List<Student> getAlleStudenten(){
        return this.klas.getStudenten();
    }

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student nieuweStudent(Student nieuweStudent){
        this.klas.voegStudentToe(nieuweStudent);
        return nieuweStudent;
    }


    @PUT
    @Path("{id}")
    public String updateStudent(@PathParam("id") String studentId, String jsonNieuweStudent){

        StringReader blergh = new StringReader(jsonNieuweStudent);
        JsonReader reader = Json.createReader(blergh);
        JsonObject readObject = reader.readObject();

        String naam = readObject.getString("naam");

        long gevraagdId = Long.parseLong(studentId);
        Student gevondenStudent = this.klas.getStudent(gevraagdId);
        gevondenStudent.setName(naam);

        return gevondenStudent.toJson().toString();
    }


    @GET
    @Path("1")
    public String getEnkeleStudent(){
        Student gevondenStudent = this.klas.getStudent(1);

        return gevondenStudent.toJson().toString();
    }


    @GET
    @Path("2")
    public String getEnkeleStudent2(){
        Student gevondenStudent = this.klas.getStudent(2);

        return gevondenStudent.toJson().toString();
    }

    @GET
    @Path("{id}")
    public String getEnkeleStudent(@PathParam("id") String studentId){
        long gevraagdId = Long.parseLong(studentId);
        Student gevondenStudent = this.klas.getStudent(gevraagdId);

        return gevondenStudent.toJson().toString();
    }

    @DELETE
    @Path("{id}")
    public String verwijderStudent(@PathParam("id") String studentId){
        long gevraagdId = Long.parseLong(studentId);
        Student gevondenStudent = this.klas.getStudent(gevraagdId);

        this.klas.verwijderStudent(gevondenStudent);

        return "Hij is weg";
    }

}
