package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.User;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface UserDaoImpl extends BaseDaoImpl<User>{
    User findByLogin(String login) throws SQLException;
}
