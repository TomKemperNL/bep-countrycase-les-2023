package nl.hu.bep.countrycase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;
import java.util.List;

public class TestMetJackson {
    public static void main(String[] args) throws JsonProcessingException {
        List<Student> students = Klas.getKlas().getStudenten();
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(students);
        System.out.println(json);

        String lennardAlsJson = "{\"naam\":\"Lennard\",\"id\":1}";
        Student gelezen = om.readValue(lennardAlsJson, Student.class);

        System.out.println(gelezen.getNaam());

    }
}
