/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.interfaces.IdIncrement;

/**
 *
 * @author Valera Yalov4uk
 */
public class Statement implements IdIncrement{

    private int id;
    private Enrollee enrollee;
    private Faculty faculty;
    private boolean statement;
    private static int i = 0;

    public Statement() {
    }

    public Statement(Enrollee enrollee, Faculty faculty, boolean isStatement) {
        this.id = i++;
        this.enrollee = enrollee;
        this.faculty = faculty;
        this.statement = isStatement;
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

    public boolean isIsStatement() {
        return statement;
    }

    public void setIsStatement(boolean isStatement) {
        this.statement = isStatement;
    }

    @Override
    public String toString() {
        return "Statement{" + "id=" + id + ", enrollee=" + enrollee + ", faculty=" + faculty + ", statement=" + statement + '}';
    }
}
