package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.RegisteredUsersDaoImpl;
import by.training.nc.dev3.iterfaces.dao.RequiredSubjectsDaoImpl;
import by.training.nc.dev3.iterfaces.dao.SubjectDaoImpl;
import by.training.nc.dev3.iterfaces.dao.SubjectNameDaoImpl;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IEnrolleeManager {

    boolean registerEnrollee(Faculty faculty, IInOutManager inOutManager,
                             RegisteredUsersDaoImpl registeredUsersDao,
                             RequiredSubjectsDaoImpl requiredSubjectsDao,
                             SubjectDaoImpl subjectDao, SubjectNameDaoImpl subjectNameDao) throws SQLException;

    void setEnrollee(User enrollee);

    User getEnrollee();
}
