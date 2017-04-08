/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class Faculty extends Entity {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    private String name;
    private int maxSize;

    private List<SubjectName> requiredSubjects;
    private List<User> registeredUsers;

    public Faculty() {
        super(count++);
        requiredSubjects = new ArrayList<>();
        registeredUsers = new ArrayList<>();
    }

    public Faculty(String name, int maxSize, List<SubjectName> requiredSubjects) {
        super(count++);
        this.name = name;
        this.maxSize = maxSize;
        this.requiredSubjects = requiredSubjects;
        registeredUsers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
    public List<SubjectName> getRequiredSubjects() {
        return requiredSubjects;
    }

    /**
     * @param requiredSubjects
     */
    public void setRequiredSubjects(List<SubjectName> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    /**
     * @return
     */
    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    /**
     * @param registeredUsers
     */
    public void setRegisteredEntrants(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                super.toString() +
                ", name='" + name + '\'' +
                ", maxSize=" + maxSize +
                ", requiredSubjects=" + requiredSubjects +
                ", registeredUsers=" + registeredUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Faculty faculty = (Faculty) o;

        if (maxSize != faculty.maxSize) return false;
        if (name != faculty.name) return false;
        if (requiredSubjects != null ? !requiredSubjects.equals(faculty.requiredSubjects) : faculty.requiredSubjects != null)
            return false;
        return registeredUsers != null ? registeredUsers.equals(faculty.registeredUsers) : faculty.registeredUsers == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + maxSize;
        result = 31 * result + (requiredSubjects != null ? requiredSubjects.hashCode() : 0);
        result = 31 * result + (registeredUsers != null ? registeredUsers.hashCode() : 0);
        return result;
    }
}
