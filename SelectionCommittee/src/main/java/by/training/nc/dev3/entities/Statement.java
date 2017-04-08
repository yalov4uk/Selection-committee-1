/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Valera Yalov4uk
 */
public class Statement extends Entity implements Comparable<Object> {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    private Calendar date;
    private User user;
    private int userId;
    private Faculty faculty;
    private int facultyId;

    public Statement() {
        super(count++);
        this.date = new GregorianCalendar();
    }

    public Statement(User user, Faculty faculty) {
        super(count++);
        this.user = user;
        this.faculty = faculty;
        this.date = new GregorianCalendar();
    }

    public static int getCount() {
        return count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Statement{" +
                super.toString() +
                ", date=" + date.getTime() +
                ", user=" + user +
                ", userId='" + userId + '\'' +
                ", faculty=" + faculty +
                ", facultyId='" + facultyId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.user.getAverageScore(this.faculty).compareTo(((Statement) o).getUser().getAverageScore(this.faculty));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Statement statement = (Statement) o;

        if (date != null ? !date.equals(statement.date) : statement.date != null) return false;
        if (user != null ? !user.equals(statement.user) : statement.user != null) return false;
        if (!(userId == statement.userId)) return false;
        if (faculty != null ? !faculty.equals(statement.faculty) : statement.faculty != null) return false;
        return facultyId == statement.facultyId;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + facultyId;
        return result;
    }
}
