/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.initializers.FacultyInitializer;
import by.training.nc.dev3.initializers.PointInitializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class DataBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Enrollee> entrants;
    private List<Admin> admins;
    private List<Point> points;
    private List<Faculty> faculties;
    private List<Statement> statements;

    public DataBase() {
        entrants = new ArrayList<>();
        admins = new ArrayList<>();
        points = PointInitializer.initialize();
        faculties = FacultyInitializer.initialize();
        statements = new ArrayList<>();
    }

    /**
     * @return
     */
    public List<Enrollee> getEntrants() {
        return entrants;
    }

    /**
     * @param entrants
     */
    public void setEntrants(List<Enrollee> entrants) {
        this.entrants = entrants;
    }

    /**
     * @return
     */
    public List<Admin> getAdmins() {
        return admins;
    }

    /**
     * @param admins
     */
    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    /**
     * @return
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * @param points
     */
    public void setPoints(List<Point> points) {
        this.points = points;
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
}
