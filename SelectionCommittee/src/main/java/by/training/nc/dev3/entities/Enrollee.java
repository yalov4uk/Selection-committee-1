/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.enums.Subject;
import java.util.Map;

/**
 *
 * @author Valera Yalov4uk
 */
public class Enrollee extends Human {

    private int certificate;
    private Map<Subject, Integer> subjects;

    public Enrollee() {
        super();
    }

    public Enrollee(String name) {
        super(name);
    }

    public Enrollee(String name, int certificate, Map<Subject, Integer> subjects) {
        super(name);
        this.certificate = certificate;
        this.subjects = subjects;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public Map<Subject, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<Subject, Integer> subjects) {
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Enrollee{" + "id=" + id + ", name=" + name + "certificate=" + certificate + ", subjects=" + subjects + '}';
    }
}
