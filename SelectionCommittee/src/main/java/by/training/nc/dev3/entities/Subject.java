/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * @author Valera Yalov4uk
 */
public class Subject extends Entity {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    private int value;
    private SubjectName name;
    private int subjectNameId;

    public Subject() {
        super(count++);
    }

    public Subject(SubjectName name) {
        super(count++);
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public SubjectName getName() {
        return name;
    }

    public void setName(SubjectName name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Subject subject = (Subject) o;

        if (value != subject.value) return false;
        return name == subject.name;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                super.toString() +
                ", value=" + value +
                ", name=" + name +
                ", subjectNameId='" + subjectNameId + '\'' +
                '}';
    }
}
