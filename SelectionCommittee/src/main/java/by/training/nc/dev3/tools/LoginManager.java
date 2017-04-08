package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.ILoginManager;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public class LoginManager implements ILoginManager {

    public User login(List<User> users, IInOutManager inOutManager) {
        String login = inOutManager.inputString("Enter login");
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(inOutManager.inputString("Enter password"))) {
                    return user;
                }
            }
        }
        inOutManager.outputString("Incorrect login or password");
        return null;
    }
}
