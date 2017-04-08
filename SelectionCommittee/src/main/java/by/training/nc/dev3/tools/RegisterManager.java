package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.IRegisterManager;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public class RegisterManager implements IRegisterManager {

    public User register(List<User> users, IInOutManager inOutManager) {
        while (true) {
            boolean flag = false;
            String login = inOutManager.inputString("Enter new login");
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    inOutManager.outputString("Login already used");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return new User(inOutManager.inputString("Enter your name"), login,
                        inOutManager.inputString("Enter your password"), 1);
            }
        }
    }
}
