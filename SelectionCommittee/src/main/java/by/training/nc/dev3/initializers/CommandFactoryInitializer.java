package by.training.nc.dev3.initializers;

import by.training.nc.dev3.commands.LoginCommand;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/16/2017.
 */
public class CommandFactoryInitializer {

    public static Map<String, Command>  initialize() {
        Map<String, Command> map = new HashMap<>();
        map.put("login", new LoginCommand());
        return map;
    }
}
