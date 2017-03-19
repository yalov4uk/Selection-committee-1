/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.IdIncrement;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.PointName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class Faculty extends IdIncrement {

    private int id;
    private FacultyName name;
    private int maxSize;
    private List<PointName> requiredPoints;
    private List<Enrollee> registeredEntrants;

    public Faculty() {
        i++;
    }

    public Faculty(String name, int maxSize, List<PointName> requiredPoints) {
        this.id = i++;
        this.name = FacultyName.valueOf(name);
        this.maxSize = maxSize;
        this.requiredPoints = requiredPoints;
        registeredEntrants = new ArrayList();
    }

    public Faculty(FacultyName name, int maxSize, List<PointName> requiredPoints) {
        this.id = i++;
        this.name = name;
        this.maxSize = maxSize;
        this.requiredPoints = requiredPoints;
        registeredEntrants = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FacultyName getName() {
        return name;
    }

    public void setName(FacultyName name) {
        this.name = name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<PointName> getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(List<PointName> requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

    public List<Enrollee> getRegisteredEntrants() {
        return registeredEntrants;
    }

    public void setRegisteredEntrants(List<Enrollee> registeredEntrants) {
        this.registeredEntrants = registeredEntrants;
    }

    public void setRegisteredEntrant(Enrollee enrollee) {
        this.registeredEntrants.add(enrollee);
    }

    @Override
    public String toString() {
        return "Faculty{" + "id=" + id + ", name=" + name + ", maxSize="
                + maxSize + ", requiredPoints=" + requiredPoints
                + ", registeredEntrants=" + registeredEntrants + '}';
    }
}
