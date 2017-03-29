/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;
import by.training.nc.dev3.abstracts.Point;

/**
 * @author Valera Yalov4uk
 */
public class Statement extends Entity implements Comparable<Object> {

    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private Enrollee enrollee;
    private Faculty faculty;

    public Statement() {
        super();
        count++;
    }

    public Statement(Enrollee enrollee, Faculty faculty) {
        super();
        this.enrollee = enrollee;
        this.faculty = faculty;
        count++;
    }

    public static int getCount() {
        return count;
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
        return "Statement{" + super.toString() + ", enrollee=" + enrollee + ", faculty=" + faculty + ", count=" + count + '}';
    }

    @Override
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Statement statement = (Statement) o;

        if (enrollee != null ? !enrollee.equals(statement.enrollee) : statement.enrollee != null) return false;
        return faculty != null ? faculty.equals(statement.faculty) : statement.faculty == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (enrollee != null ? enrollee.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }
}
