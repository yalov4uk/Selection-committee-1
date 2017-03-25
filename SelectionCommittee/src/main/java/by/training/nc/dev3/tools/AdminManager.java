/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.iterfaces.IAdminManager;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Valera Yalov4uk
 */
public class AdminManager implements IAdminManager {

    private Admin admin;

    public Statement createStatement(List<Faculty> faculties, int id) {
        for (Faculty faculty : faculties) {
            for (Enrollee enrollee : faculty.getRegisteredEntrants()) {
                if (enrollee.getId() == id) {
                    Statement statement = new Statement(enrollee, faculty);
                    faculty.getRegisteredEntrants().remove(enrollee);
                    return statement;
                }
            }
        }
        return null;
    }

    public Statement registerStatement(Faculty faculty, String name) {
        ListIterator<Enrollee> listIter = faculty.getRegisteredEntrants().listIterator();
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

    public AdminManager() {
    }

    public AdminManager(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
