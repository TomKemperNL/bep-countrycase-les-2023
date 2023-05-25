package nl.hu.bep.countrycase;

import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class TestReflectieEnJson {

    public static void main(String[] args) throws IllegalAccessException {

        JsonArrayBuilder array = Json.createArrayBuilder();
        for(Student s: Klas.getKlas().getStudenten()){
            JsonObjectBuilder builder = Json.createObjectBuilder();

            for(Field f: Student.class.getDeclaredFields()){
                f.setAccessible(true);
                builder.add(f.getName(), f.get(s).toString());
            }

            array.add(builder);
        }

        System.out.println(array.build().toString());
    }
}
