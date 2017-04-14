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
public class User extends Entity {

    private static int count = 0;

    private String name;
    private String login;
    private String password;

    private Role role;
    private int roleId;

    private List<Subject> subjects;

    public Integer getAverageScore(Faculty faculty) {
        int result = 0;
        for (Subject subject : subjects) {
            if (faculty.getRequiredSubjects().contains(subject.getSubjectName())) {
                result += subject.getValue();
            }
        }
        return result;
    }

    public User() {
        super(count++);
    }

    public User(String name, String login, String password, int roleId) {
        super(count++);
        this.name = name;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.subjects = new ArrayList<>();
    }

    public User(int id, String name, String login, String password, int roleId) {
        super(id);
        this.name = name;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.subjects = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((!(o instanceof User))) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (!(roleId == user.roleId)) return false;
        return subjects != null ? subjects.equals(user.subjects) : user.subjects == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + roleId;
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", roleId='" + roleId + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
