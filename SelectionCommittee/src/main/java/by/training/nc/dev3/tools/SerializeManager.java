/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Valera Yalov4uk
 * @param <T>
 */
public class SerializeManager<T> {

    private final String filepath
            = "src/main/java/by/training/nc/dev3/files/statements.txt";

    public void serialize(T db) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filepath))) {
            oos.writeObject(db);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public T deserilize() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filepath))) {
            return (T) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
