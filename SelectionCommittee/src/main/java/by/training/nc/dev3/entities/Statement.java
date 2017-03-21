/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.IdIncrement;
import by.training.nc.dev3.abstracts.Point;
import java.io.Serializable;

/**
 *
 * @author Valera Yalov4uk
 */
public class Statement extends IdIncrement implements Comparable {

    private int id;
    private Enrollee enrollee;
    private Faculty faculty;

    public Statement() {
        this.id = getNextI();
    }

    public Statement(Enrollee enrollee, Faculty faculty) {
        this.id = getNextI();
        this.enrollee = enrollee;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enrollee getEnrollee() {
        return enrollee;
    }

    public void setEnrollee(Enrollee enrollee) {
        this.enrollee = enrollee;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Statement{" + "id=" + id + ", enrollee=" + enrollee
                + ", faculty=" + faculty + '}';
    }

    public int compareTo(Object o) {
        int result = 0;
        for (Point point : this.enrollee.getPoints()) {
            result -= point.getValue();
        }
        for (Point point : ((Statement) o).enrollee.getPoints()) {
            result += point.getValue();
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + (this.enrollee != null ? this.enrollee.hashCode() : 0);
        hash = 53 * hash + (this.faculty != null ? this.faculty.hashCode() : 0);
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
        final Statement other = (Statement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.enrollee != other.enrollee && (this.enrollee == null || !this.enrollee.equals(other.enrollee))) {
            return false;
        }
        if (this.faculty != other.faculty && (this.faculty == null || !this.faculty.equals(other.faculty))) {
            return false;
        }
        return true;
    }
}
