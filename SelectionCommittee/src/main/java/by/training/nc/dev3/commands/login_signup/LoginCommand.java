package by.training.nc.dev3.commands.login_signup;

import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;
import by.training.nc.dev3.localisation.Bundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/**
 * Created by Valera Yalov4uk on 4/16/2017.
 */
public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        String login = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.findByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            page = "/jsps/index.jsp";
        } else {
            ResourceBundle resourceBundle = Bundle.getInstance();
            String WRONG_LOG_OR_PAS = resourceBundle.getString("WRONG_LOG_OR_PAS");
            request.setAttribute("errorMessage", WRONG_LOG_OR_PAS);
            page = "/jsps/error/error.jsp";
        }
        userDao.close();
        return page;
    }
}
