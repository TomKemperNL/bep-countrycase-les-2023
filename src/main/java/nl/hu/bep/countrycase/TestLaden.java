package nl.hu.bep.countrycase;

import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;

public class TestLaden {
    public static void main(String[] args) {
        PersistenceManager.loadKlas();

        for(Student s: Klas.getKlas().getStudenten()){
            System.out.println(s.getNaam());
        }
    }
}
