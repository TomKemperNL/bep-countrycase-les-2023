package nl.hu.bep.countrycase.webservices;

import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;

import javax.json.*;
import javax.ws.rs.*;
import java.io.StringReader;

@Path("/klas")
public class KlasResource {

    private Klas klas = Klas.getKlas();

    @GET
    public String getAlleStudenten(){
        Klas klas = this.klas;
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for(Student s: klas.getStudenten()){
            arrayBuilder.add(s.toJson());
        }
        return arrayBuilder.build().toString();
    }

    @POST
    public String nieuweStudent(String jsonNieuweStudent){

        StringReader inKleineStukjes = new StringReader(jsonNieuweStudent);
        JsonReader reader = Json.createReader(inKleineStukjes);
        JsonObject readObject = reader.readObject();

        String naam = readObject.getString("naam");

        Student nieuweStudent = new Student(naam);
        this.klas.voegStudentToe(nieuweStudent);

        return nieuweStudent.toJson().toString();
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
