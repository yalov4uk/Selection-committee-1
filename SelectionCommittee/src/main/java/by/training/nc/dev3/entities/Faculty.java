/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.Subject;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class Faculty {

    private int id;
    private FacultyName name;
    private int maxSize;
    private List<Subject> requiredSubject;
    private List<Enrollee> pastEntrants;
    private static int i = 0;

    public Faculty() {
    }

    public Faculty(String name, int maxSize, List<Subject> requiredSubject) {
        this.id = i++;
        this.name = FacultyName.valueOf(name);
        this.maxSize = maxSize;
        this.requiredSubject = requiredSubject;
    }

    public Faculty(FacultyName name, int maxSize, List<Subject> requiredSubject) {
        this.id = i++;
        this.name = name;
        this.maxSize = maxSize;
        this.requiredSubject = requiredSubject;
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

    public List<Subject> getRequiredSubject() {
        return requiredSubject;
    }

    public void setRequiredSubject(List<Subject> requiredSubject) {
        this.requiredSubject = requiredSubject;
    }

    public List<Enrollee> getPastEntrants() {
        return pastEntrants;
    }

    public void setPastEntrants(List<Enrollee> pastEntrants) {
        this.pastEntrants = pastEntrants;
    }

    @Override
    public String toString() {
        return "Faculty{" + "id=" + id + ", name=" + name + ", maxSize=" + maxSize + ", requiredSubject=" + requiredSubject + ", pastEntrants=" + pastEntrants + '}';
    }
}
