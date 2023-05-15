package nl.hu.bep.countrycase.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class KlasTest {

    @Test
    void geenBobAllowed() {
        Klas k = new Klas("V1D");

        try {
            k.voegStudentToe(new Student("Bob"));
            fail("Shit, bob zit er in");
        }catch (Exception ex){}
    }

    @Test
    public void sneakBobDeKlasIn(){
        Student sneakyBob = new Student("Bob");
        Klas k = new Klas("V1D");

        k.getStudenten().add(sneakyBob);

        assertFalse(k.getStudenten().contains(sneakyBob));
    }
}