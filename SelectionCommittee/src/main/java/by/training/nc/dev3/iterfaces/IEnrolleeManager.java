package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;
import by.training.nc.dev3.iterfaces.dao.RequiredSubjectDao;
import by.training.nc.dev3.iterfaces.dao.SubjectDao;
import by.training.nc.dev3.iterfaces.dao.SubjectNameDao;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IEnrolleeManager {

    boolean registerEnrollee(Faculty faculty, IInOutManager inOutManager,
                             RegisteredUserDao registeredUserDao,
                             RequiredSubjectDao requiredSubjectDao,
                             SubjectDao subjectDao, SubjectNameDao subjectNameDao);

    void setEnrollee(User enrollee);

    User getEnrollee();
}
