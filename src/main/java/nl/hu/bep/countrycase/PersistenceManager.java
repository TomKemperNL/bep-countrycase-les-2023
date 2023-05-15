package nl.hu.bep.countrycase;

import nl.hu.bep.countrycase.model.Klas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersistenceManager {
    public static void saveKlas(){
        Klas opTeSlaan = Klas.getKlas();
        try {
            OutputStream os = Files.newOutputStream(Path.of("C:\\temp\\klas.obj"));

            ObjectOutputStream objectSchrijver = new ObjectOutputStream(os);
            objectSchrijver.writeObject(opTeSlaan);


            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void loadKlas(){
        try {
            InputStream is = Files.newInputStream(Path.of("C:\\temp\\klas.obj"));
            ObjectInputStream objectIn = new ObjectInputStream(is);

            Klas gelezenKlas = (Klas) objectIn.readObject();

            Klas.laadNieuweKlas(gelezenKlas);



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
