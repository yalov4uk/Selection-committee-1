package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.User;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface UserDao extends BaseDao<User> {

    User findByLogin(String login);
}
