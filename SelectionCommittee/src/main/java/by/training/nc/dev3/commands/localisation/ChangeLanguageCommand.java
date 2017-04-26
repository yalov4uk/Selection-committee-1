package by.training.nc.dev3.commands.localisation;

import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language");
        request.getSession().setAttribute("language", new Locale(language.split(
                " ")[0], language.split(" ")[1]));
        return "/jsps/index.jsp";
    }
}
