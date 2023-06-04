package services;

import models.ModeloBase;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ArmazenamentoService {

    public void save(ArrayList<? extends ModeloBase> dados, String arquivo){
        try {
            String absPath = new File("").getAbsolutePath() + "\\data\\";
            Files.createDirectories(Path.of(absPath));
            File file = new File(absPath + arquivo + ".dat");
            ObjectOutputStream output = new ObjectOutputStream(new
                    FileOutputStream(file));
            output.writeObject(dados);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<? extends ModeloBase> load(String arquivo) {
        try {
            String absPath = new File("").getAbsolutePath() + "\\data\\";
            Files.createDirectories(Path.of(absPath));
            File file = new File(absPath + arquivo + ".dat");
            ObjectInputStream input = new ObjectInputStream(new
                    FileInputStream(file));
            return (ArrayList<? extends ModeloBase>) input.readObject();
        } catch (FileNotFoundException ignored){}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
