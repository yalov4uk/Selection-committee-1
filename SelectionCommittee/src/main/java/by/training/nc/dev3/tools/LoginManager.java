package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.ILoginManager;
import by.training.nc.dev3.iterfaces.dao.UserDao;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public class LoginManager implements ILoginManager {

    public User login(UserDao userDao, IInOutManager inOutManager) {
        String login = inOutManager.inputString("Enter login");
        User user = userDao.findByLogin(login);
        if (user != null){
            if (user.getPassword().equals(inOutManager.inputString("Enter password"))) {
                return user;
            }
        }
        inOutManager.outputString("Incorrect login or password");
        return null;
    }
}
