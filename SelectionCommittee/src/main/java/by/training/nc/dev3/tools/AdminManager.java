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

/**
 *
 * @author Valera Yalov4uk
 */
public class AdminManager {

    private Admin admin;

    public Statement registerStatement(Faculty faculty, String name) {
        for (Enrollee enrollee : faculty.getRegisteredEntrants()) {
            if (enrollee.getName().equals(name)) {
                Statement statement = new Statement(enrollee, faculty);
                deleteRegisteredEnrollee(statement.getEnrollee(),
                        statement.getFaculty());
                return statement;
            }
        }
        return null;
    }

    public Statement registerStatement(Faculty faculty, int id) {
        for (Enrollee enrollee : faculty.getRegisteredEntrants()) {
            Statement statement = new Statement(enrollee, faculty);
            deleteRegisteredEnrollee(statement.getEnrollee(),
                    statement.getFaculty());
            return statement;
        }
        return null;
    }

    private void deleteRegisteredEnrollee(Enrollee enrollee, Faculty faculty) {
        faculty.getRegisteredEntrants().remove(enrollee);
    }

    public AdminManager() {
    }

    public AdminManager(Admin admin) {
        this.admin = admin;
    }
}
