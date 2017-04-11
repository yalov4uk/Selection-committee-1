package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.RegisteredUsersDaoImpl;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IEnrolleeManager {

    boolean registerEnrollee(Faculty faculty, IInOutManager inOutManager, RegisteredUsersDaoImpl registeredUsersDao) throws SQLException;

    void setEnrollee(User enrollee);

    User getEnrollee();
}
