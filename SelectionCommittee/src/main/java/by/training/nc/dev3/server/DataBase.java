/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.initializers.FacultyInitializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class DataBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Human> entrants;
    private List<Human> admins;
    private List<Faculty> faculties;
    private List<Statement> statements;

    public DataBase() {
        entrants = new ArrayList<>();
        admins = new ArrayList<>();
        faculties = FacultyInitializer.initialize();
        statements = new ArrayList<>();

        admins.add(new Admin("Admin1", "admin", "admin"));
    }

    /**
     * @return
     */
    public List<Human> getEntrants() {
        return entrants;
    }

    /**
     * @param entrants
     */
    public void setEntrants(List<Human> entrants) {
        this.entrants = entrants;
    }

    /**
     * @return
     */
    public List<Human> getAdmins() {
        return admins;
    }

    /**
     * @param admins
     */
    public void setAdmins(List<Human> admins) {
        this.admins = admins;
    }

    /**
     * @return
     */
    public List<Faculty> getFaculties() {
        return faculties;
    }

    /**
     * @param faculties
     */
    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    /**
     * @return
     */
    public List<Statement> getStatements() {
        return statements;
    }

    /**
     * @param statements
     */
    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Human> getHumans() {
        List<Human> humans = new ArrayList<>(admins);
        humans.addAll(entrants);
        return humans;
    }
}
