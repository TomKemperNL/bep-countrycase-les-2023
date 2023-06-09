package nl.hu.bep.countrycase;

import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class TestMetStrings {
    public static void main(String[] args) {

        JsonArrayBuilder array = Json.createArrayBuilder();
        for(Student s: Klas.getKlas().getStudenten()){
            JsonObjectBuilder builder = Json.createObjectBuilder();

            builder.add("id", s.getId());
            builder.add("name", s.getNaam());

            array.add(builder);
        }

        System.out.println(array.build().toString());

    }
}
