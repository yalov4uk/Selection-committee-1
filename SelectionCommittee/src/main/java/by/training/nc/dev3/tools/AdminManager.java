/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.IAdminManager;

import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class AdminManager implements IAdminManager {

    private User admin;

    public Statement createStatement(List<Faculty> faculties, int id) {
        for (Faculty faculty : faculties) {
            for (User user : faculty.getRegisteredUsers()) {
                if (user.getId() == id) {
                    Statement statement = new Statement(user, faculty);
                    faculty.getRegisteredUsers().remove(user);
                    return statement;
                }
            }
        }
        return null;
    }

    public AdminManager() {
    }

    public AdminManager(User admin) {
        this.admin = admin;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
