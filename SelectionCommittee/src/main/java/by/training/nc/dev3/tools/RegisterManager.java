package by.training.nc.dev3.tools;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.IRegisterManager;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public class RegisterManager implements IRegisterManager {

    public Human register(List<Human> humans, IInOutManager inOutManager) {
        while (true) {
            boolean flag = false;
            String login = inOutManager.inputString("Enter new login");
            for (Human human : humans) {
                if (human.getLogin().equals(login)) {
                    inOutManager.outputString("Login already used");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return new Enrollee(inOutManager.inputString("Enter your name"), login,
                        inOutManager.inputString("Emter your password"));
            }
        }
    }
}
