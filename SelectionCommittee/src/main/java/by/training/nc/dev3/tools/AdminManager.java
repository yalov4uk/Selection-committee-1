/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Valera Yalov4uk
 * @param <T>
 */
public class AdminManager<T extends Human> {

    private T admin;

    public Statement registerStatement(Faculty faculty, String name) {
        ListIterator<Enrollee> listIter = faculty.getRegisteredEntrants().
                listIterator();
        while (listIter.hasNext()) {
            Enrollee curEnrollee = listIter.next();
            if (curEnrollee.getName().equals(name)) {
                Statement statement = new Statement(curEnrollee, faculty);
                listIter.remove();
                return statement;
            }
        }
        return null;
    }

    public Statement registerStatement(List<Faculty> list, int id) {
        for (Faculty faculty : list) {
            for (Enrollee enrollee : faculty.getRegisteredEntrants()) {
                Statement statement = new Statement(enrollee, faculty);
                faculty.getRegisteredEntrants().remove(enrollee);
                return statement;
            }
        }
        return null;
    }

    public AdminManager() {
    }

    public AdminManager(T admin) {
        this.admin = admin;
    }

    public T getAdmin() {
        return admin;
    }

    public void setAdmin(T admin) {
        this.admin = admin;
    }
}
