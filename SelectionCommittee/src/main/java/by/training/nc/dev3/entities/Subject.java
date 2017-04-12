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

    private SubjectName subjectName;
    private int subjectNameId;
    private User user;
    private int userId;

    public Subject() {
        super(count++);
    }

    public Subject(int value, int subjectNameId, int userId) {
        super(count++);
        this.value = value;
        this.subjectNameId = subjectNameId;
        this.userId = userId;
    }

    public Subject(int id, int value, int subjectNameId, int userId) {
        super(id);
        this.value = value;
        this.subjectNameId = subjectNameId;
        this.userId = userId;
    }

    public static int getCount() {
        return count;
    }

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName name) {
        this.subjectName = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSubjectNameId() {
        return subjectNameId;
    }

    public void setSubjectNameId(int subjectNameId) {
        this.subjectNameId = subjectNameId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((!(o instanceof Subject))) return false;
        if (!super.equals(o)) return false;

        Subject subject = (Subject) o;

        if (value != subject.value) return false;
        if (subjectNameId != subject.subjectNameId) return false;
        if (userId != subject.userId) return false;
        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        return user != null ? user.equals(subject.user) : subject.user == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + value;
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + subjectNameId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                super.toString() +
                ", value=" + value +
                ", subjectName=" + subjectName +
                ", subjectNameId=" + subjectNameId +
                ", user=" + user +
                ", userId=" + userId +
                '}';
    }
}
