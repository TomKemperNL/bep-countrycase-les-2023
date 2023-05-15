package nl.hu.bep.countrycase;

import nl.hu.bep.countrycase.model.Klas;
import nl.hu.bep.countrycase.model.Student;

public class TestMain {
    public static void main(String[] args) {
        Klas k = Klas.getKlas();
        k.voegStudentToe(new Student("Test"));

        PersistenceManager.saveKlas();
    }
}
