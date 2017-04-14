package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.UserDao;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface ILoginManager {

    User login(UserDao userDao, IInOutManager inOutManager);
}
