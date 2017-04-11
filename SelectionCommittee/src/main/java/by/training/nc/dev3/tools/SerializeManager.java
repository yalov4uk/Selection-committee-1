/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.iterfaces.ISerializeManager;

import java.io.*;

/**
 * @author Valera Yalov4uk
 */
public class SerializeManager<T> implements ISerializeManager<T> {

    private File file = new File("files" + File.separator + "serializedDb.txt");

    public boolean serialize(T object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public T deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (T) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
