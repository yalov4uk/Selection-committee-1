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

    private final String filepath = "src/main/resources/files/serializedDb.txt";

    public boolean serialize(DataBase object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(object);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public DataBase deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            return (DataBase) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
