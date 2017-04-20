package by.training.nc.dev3.commands.localisation;

import by.training.nc.dev3.iterfaces.factories.commands.Command;
import by.training.nc.dev3.localisation.Bundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Bundle.change();
        return "/jsps/index.jsp";
    }
}
