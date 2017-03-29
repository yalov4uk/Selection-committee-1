/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.iterfaces.ISerializeManager;
import by.training.nc.dev3.server.DataBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Valera Yalov4uk
 */
public class SerializeManager implements ISerializeManager<DataBase> {

    private final String filename = "src/main/resources/files/serializedDb.txt";
    //getClass().getClassLoader().getResource(filename).getFile() dont work correctly, return path "target/classes/..."

    public boolean serialize(DataBase object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public DataBase deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (DataBase) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
