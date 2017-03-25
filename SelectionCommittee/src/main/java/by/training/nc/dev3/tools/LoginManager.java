package by.training.nc.dev3.tools;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.ILoginManager;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public class LoginManager implements ILoginManager {

    public Human login(List<Human> humans, IInOutManager inOutManager) {
        String login = inOutManager.inputString("Enter login");
        for (Human human : humans) {
            if (human.getLogin().equals(login)) {
                if (human.getPassword().equals(inOutManager.inputString("Enter password"))) {
                    return human;
                }
            }
        }
        inOutManager.outputString("Incorrect login or password");
        return null;
    }
}
