package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.RegisteredUser;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface RegisteredUsersDaoImpl extends BaseDaoImpl<RegisteredUser>{
    RegisteredUser findRegisteredUserByIds(int userId, int facultyId) throws SQLException;
}
