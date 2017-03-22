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
 *
 * @author Valera Yalov4uk
 */
public class Faculty extends Entity {

    private static final long serialVersionUID = 1L;

    private FacultyName name;
    private int maxSize;
    private List<PointName> requiredPoints;
    private List<Enrollee> registeredEntrants;

    private static int count = 0;

    public Faculty() {
        super();
        requiredPoints = new ArrayList<>();
        registeredEntrants = new ArrayList<>();
        count++;
    }

    public Faculty(FacultyName name, int maxSize,
            List<PointName> requiredPoints) {
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
     *
     * @return
     */
    public List<PointName> getRequiredPoints() {
        return requiredPoints;
    }

    /**
     *
     * @param requiredPoints
     */
    public void setRequiredPoints(List<PointName> requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

    /**
     *
     * @return
     */
    public List<Enrollee> getRegisteredEntrants() {
        return registeredEntrants;
    }

    /**
     *
     * @param registeredEntrants
     */
    public void setRegisteredEntrants(List<Enrollee> registeredEntrants) {
        this.registeredEntrants = registeredEntrants;
    }

    /**
     *
     * @param enrollee
     */
    public void setRegisteredEntrant(Enrollee enrollee) {
        this.registeredEntrants.add(enrollee);
    }

    @Override
    public String toString() {
        return "Faculty{" + "id=" + id + ", name=" + name + ", maxSize="
                + maxSize + ", requiredPoints=" + requiredPoints
                + ", registeredEntrants=" + registeredEntrants + ", count="
                + count + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 11 * hash + this.maxSize;
        hash = 11 * hash + (this.requiredPoints != null
                ? this.requiredPoints.hashCode() : 0);
        hash = 11 * hash + (this.registeredEntrants != null
                ? this.registeredEntrants.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Faculty other = (Faculty) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.maxSize != other.maxSize) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        if (this.requiredPoints != other.requiredPoints
                && (this.requiredPoints == null
                || !this.requiredPoints.equals(other.requiredPoints))) {
            return false;
        }
        if (this.registeredEntrants != other.registeredEntrants
                && (this.registeredEntrants == null
                || !this.registeredEntrants.equals(other.registeredEntrants))) {
            return false;
        }
        return true;
    }
}
