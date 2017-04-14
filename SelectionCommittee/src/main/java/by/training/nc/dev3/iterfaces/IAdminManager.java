package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;
import by.training.nc.dev3.iterfaces.dao.StatementDao;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IAdminManager {

    void createStatement(RegisteredUserDao registeredUserDao, StatementDao statementDao,
                         IInOutManager inOutManager);

    void setAdmin(User admin);
}
