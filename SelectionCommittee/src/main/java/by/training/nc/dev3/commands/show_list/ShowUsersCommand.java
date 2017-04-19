package by.training.nc.dev3.commands.show_list;

import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class ShowUsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/show_list/users.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        List<User> users = userDao.getAll();
        request.setAttribute("users", users);
        userDao.close();
        return page;
    }
}
