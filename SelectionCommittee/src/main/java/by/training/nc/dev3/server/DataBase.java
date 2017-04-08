/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.initializers.FacultyInitializer;
import by.training.nc.dev3.initializers.RoleInitializer;
import by.training.nc.dev3.initializers.SubjectNameInitializer;
import by.training.nc.dev3.initializers.UserInitializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class DataBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Faculty> faculties;
    private List<Role> roles;
    private List<Statement> statements;
    private List<Subject> subjects;
    private List<SubjectName> subjectNames;
    private List<User> users;

    public DataBase() {
        subjectNames = SubjectNameInitializer.initialize();
        faculties = FacultyInitializer.initialize(subjectNames);
        roles = RoleInitializer.initialize();
        statements = new ArrayList<>();
        subjects = new ArrayList<>();
        users = UserInitializer.initialize();
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<SubjectName> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(List<SubjectName> subjectNames) {
        this.subjectNames = subjectNames;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
