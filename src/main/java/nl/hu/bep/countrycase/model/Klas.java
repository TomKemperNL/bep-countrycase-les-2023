package nl.hu.bep.countrycase.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Klas implements Serializable {

    private static Klas deKlas = new Klas("V1D",
            List.of(
                    new Student("Lennard"),
                    new Student("Rukiya"),
                    new Student("Danny")));

    public static Klas getKlas(){
        return deKlas;
    }

    public static void laadNieuweKlas(Klas gelezenKlas) {
        deKlas = gelezenKlas;
    }

    private String naam;
    private ArrayList<Student> studenten = new ArrayList<>();

    public Klas(String naam) {
        this(naam, new ArrayList<>());
    }


    public Klas(String naam, List<Student> startStudenten) {
        this.studenten.addAll(startStudenten);
        this.naam = naam;
    }


    public List<Student> getStudenten() {
        return new ArrayList<>(studenten);
    }

    public void voegStudentToe(Student student){
        if(student.getNaam().equals("Bob")){
            throw new RuntimeException("Geen Bob in deze klas");
        }
        this.studenten.add(student);
    }


    public String getNaam() {
        return naam;
    }

    public Student getStudent(long gevraagdId) {
        for(Student s: this.getStudenten()){
            if(s.getId() == gevraagdId){
                return s;
            }
        }
        return null;
    }

    public void verwijderStudent(Student gevondenStudent) {
        this.studenten.remove(gevondenStudent);
    }
}
