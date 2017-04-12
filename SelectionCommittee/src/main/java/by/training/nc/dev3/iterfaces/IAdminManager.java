package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.RegisteredUsersDaoImpl;
import by.training.nc.dev3.iterfaces.dao.StatementDaoImpl;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IAdminManager {

    void createStatement(RegisteredUsersDaoImpl registeredUsersDao, StatementDaoImpl statementDao,
                              IInOutManager inOutManager) throws SQLException;

    void setAdmin(User admin);
}
