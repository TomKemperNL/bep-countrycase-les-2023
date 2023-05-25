package nl.hu.bep.countrycase;

import nl.hu.bep.countrycase.model.Student;

import java.lang.reflect.Field;

public class TestReflectie {

    public static void main(String[] args) throws IllegalAccessException {
        Student s = new Student("Tom");

        for(Field f: Student.class.getDeclaredFields()){
            f.setAccessible(true);

            System.out.println(f.getName());
            System.out.println(f.get(s));
        }
    }
}
