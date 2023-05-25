package nl.hu.bep.countrycase.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.Serializable;

public class Student implements Serializable {

    private static long sharedId = 1;
    private String naam;
    private long id;

    public Student(){
        System.out.println("Ik wordt aangeroepen vanuit Jackson");
    }

    public Student(String zxc) {
        this.naam = zxc;
        this.id = sharedId;
        sharedId++;
    }

    public String getNaam() {
        return naam;
    }

    public long getId() {
        return this.id;
    }

    public JsonObject toJson(){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        objectBuilder.add("name", this.getNaam());
        objectBuilder.add("id", this.getId());

        return objectBuilder.build();
    }

    public void setName(String naam) {
        this.naam = naam;
    }
}
