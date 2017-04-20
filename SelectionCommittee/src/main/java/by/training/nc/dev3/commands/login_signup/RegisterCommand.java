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
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        String login = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        if (userDao.findByLogin(login) == null) {
            User user = userDao.persist(new User(name, login, password, 1));
            request.getSession().setAttribute("user", user);
            page = "/jsps/index.jsp";
        } else {
            ResourceBundle resourceBundle = Bundle.getInstance();
            String LOGIN_UNAVAILABLE = resourceBundle.getString("LOGIN_UNAVAILABLE");
            request.setAttribute("errorMessage", LOGIN_UNAVAILABLE);
            page = "/jsps/error.jsp";
        }
        userDao.close();
        return page;
    }
}
