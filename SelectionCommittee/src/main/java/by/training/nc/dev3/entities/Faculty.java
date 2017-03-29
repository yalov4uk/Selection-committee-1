/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.PointName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class Faculty extends Entity {

    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private FacultyName name;
    private int maxSize;
    private List<PointName> requiredPoints;
    private List<Enrollee> registeredEntrants;

    public Faculty() {
        super();
        requiredPoints = new ArrayList<>();
        registeredEntrants = new ArrayList<>();
        count++;
    }

    public Faculty(FacultyName name, int maxSize, List<PointName> requiredPoints) {
        super();
        this.name = name;
        this.maxSize = maxSize;
        this.requiredPoints = requiredPoints;
        registeredEntrants = new ArrayList<>();
        count++;
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

    /**
     * @return
     */
    public List<PointName> getRequiredPoints() {
        return requiredPoints;
    }

    /**
     * @param requiredPoints
     */
    public void setRequiredPoints(List<PointName> requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

    /**
     * @return
     */
    public List<Enrollee> getRegisteredEntrants() {
        return registeredEntrants;
    }

    /**
     * @param registeredEntrants
     */
    public void setRegisteredEntrants(List<Enrollee> registeredEntrants) {
        this.registeredEntrants = registeredEntrants;
    }

    @Override
    public String toString() {
        return "Faculty{" + super.toString() + ", name=" + name + ", maxSize=" + maxSize + ", requiredPoints="
                + requiredPoints + ", registeredEntrants=" + registeredEntrants + ", count=" + count + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Faculty faculty = (Faculty) o;

        if (maxSize != faculty.maxSize) return false;
        if (name != faculty.name) return false;
        if (requiredPoints != null ? !requiredPoints.equals(faculty.requiredPoints) : faculty.requiredPoints != null)
            return false;
        return registeredEntrants != null ? registeredEntrants.equals(faculty.registeredEntrants) : faculty.registeredEntrants == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + maxSize;
        result = 31 * result + (requiredPoints != null ? requiredPoints.hashCode() : 0);
        result = 31 * result + (registeredEntrants != null ? registeredEntrants.hashCode() : 0);
        return result;
    }
}
