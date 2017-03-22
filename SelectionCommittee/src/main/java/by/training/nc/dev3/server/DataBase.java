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
import by.training.nc.dev3.tools.AdminManager;
import by.training.nc.dev3.tools.EnrolleeManager;
import by.training.nc.dev3.tools.MenuManager;
import by.training.nc.dev3.tools.SerializeManager;
import by.training.nc.dev3.tools.SystemManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class DataBase {
    
    private List<Enrollee> entrants;
    private List<Admin> admins;
    private List<Point> points;
    private List<Faculty> faculties;
    private List<Statement> statements;
    
    public DataBase() {
        entrants = new ArrayList();
        admins = new ArrayList();
        points = new ArrayList();
        faculties = new ArrayList();
        statements = new ArrayList();
    }
    
    public List<Enrollee> getEntrants() {
        return entrants;
    }

    public void setEntrants(List<Enrollee> entrants) {
        this.entrants = entrants;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }
}
