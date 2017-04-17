package by.training.nc.dev3.factories;

import by.training.nc.dev3.initializers.CommandFactoryInitializer;
import by.training.nc.dev3.iterfaces.factories.CommandFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/16/2017.
 */
public class CommandFactoryImpl implements CommandFactory {

    private Map<String, Command> map;

    private CommandFactoryImpl() {
        this.map = CommandFactoryInitializer.initialize();
    }

    public Command getCommand(String name){
        if (name != null && map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }

    private static CommandFactory ourInstance;

    public static CommandFactory getInstance() {
        if (ourInstance == null) {
            ourInstance = new CommandFactoryImpl();
        }
        return ourInstance;
    }
}
