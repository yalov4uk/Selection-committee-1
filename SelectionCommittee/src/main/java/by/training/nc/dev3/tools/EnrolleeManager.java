/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.entities.SubjectName;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.IEnrolleeManager;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.server.DataBase;

/**
 * @author Valera Yalov4uk
 */
public class EnrolleeManager implements IEnrolleeManager {

    private User enrollee;

    public boolean registerEnrollee(Faculty faculty, IInOutManager inOutManager, DataBase db) {
        if (faculty.getRegisteredUsers().contains(enrollee)) {
            inOutManager.outputString("You already have been registered");
            return false;
        }
        for (SubjectName requiredSubjectName : faculty.getRequiredSubjects()) {
            if (subjectExist(requiredSubjectName)) {
                continue;
            }
            addSubject(requiredSubjectName, inOutManager, db);
        }
        faculty.getRegisteredUsers().add(enrollee);
        return true;
    }

    private void addSubject(SubjectName requiredSubjectName, IInOutManager inOutManager, DataBase db) {
        String message = enrollee.getName() + " enter your points on the " + requiredSubjectName;
        Subject subject = new Subject(requiredSubjectName);
        subject.setValue(inOutManager.inputInteger(message, 0, 100));
        enrollee.getSubjects().add(subject);
        db.getSubjects().add(subject);
    }

    private boolean subjectExist(SubjectName requiredSubjectName) {
        for (Subject subject : enrollee.getSubjects()) {
            if (subject.getSubjectName().equals(requiredSubjectName)) {
                return true;
            }
        }
        return false;
    }

    public EnrolleeManager() {
    }

    public EnrolleeManager(User enrollee) {
        this.enrollee = enrollee;
    }

    public User getEnrollee() {
        return enrollee;
    }

    public void setEnrollee(User enrollee) {
        this.enrollee = enrollee;
    }
}
