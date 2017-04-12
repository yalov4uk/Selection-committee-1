/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.iterfaces.IEnrolleeManager;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.dao.RegisteredUsersDaoImpl;
import by.training.nc.dev3.iterfaces.dao.RequiredSubjectsDaoImpl;
import by.training.nc.dev3.iterfaces.dao.SubjectDaoImpl;
import by.training.nc.dev3.iterfaces.dao.SubjectNameDaoImpl;

import java.sql.SQLException;

/**
 * @author Valera Yalov4uk
 */
public class EnrolleeManager implements IEnrolleeManager {

    private User enrollee;

    public boolean registerEnrollee(Faculty faculty, IInOutManager inOutManager,
                                    RegisteredUsersDaoImpl registeredUsersDao,
                                    RequiredSubjectsDaoImpl requiredSubjectsDao,
                                    SubjectDaoImpl subjectDao, SubjectNameDaoImpl subjectNameDao) throws SQLException {
        if (registeredUsersDao.findRegisteredUserByIds(faculty.getId(), enrollee.getId()) != null) {
            inOutManager.outputString("You already have been registered");
            return false;
        }
        for (RequiredSubject requiredSubject : requiredSubjectsDao.findAllByFacultyId(faculty.getId())) {
            for (Subject subject : subjectDao.findAllByUserId(enrollee.getId())) {
                if (subject.getSubjectNameId() == requiredSubject.getSubjectNameId()) {
                    continue;
                }
            }
            addSubject(requiredSubject.getSubjectNameId(), inOutManager, subjectDao, subjectNameDao);
        }
        registeredUsersDao.persist(new RegisteredUser(faculty.getId(), enrollee.getId()));
        return true;
    }

    private void addSubject(int requiredSubjectNameId, IInOutManager inOutManager, SubjectDaoImpl subjectDao,
                            SubjectNameDaoImpl subjectNameDao) throws SQLException {
        SubjectName subjectName =   subjectNameDao.find(requiredSubjectNameId);
        String message = enrollee.getName() + " enter your points on the " + subjectName.getName();
        int value = inOutManager.inputInteger(message, 0, 100);
        subjectDao.persist(new Subject(value, requiredSubjectNameId, enrollee.getId()));
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
