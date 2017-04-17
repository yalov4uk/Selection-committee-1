package by.training.nc.dev3.iterfaces.factories;

import by.training.nc.dev3.iterfaces.factories.commands.Command;

/**
 * Created by Valera Yalov4uk on 4/16/2017.
 */
public interface CommandFactory {
    Command getCommand(String name);
}
