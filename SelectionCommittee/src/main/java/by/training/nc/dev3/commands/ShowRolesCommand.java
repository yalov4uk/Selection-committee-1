package by.training.nc.dev3.commands;

import by.training.nc.dev3.dao.RoleDaoImpl;
import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.Role;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.RoleDao;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class ShowRolesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/roles.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        User curUser = (User) request.getSession().getAttribute("user");
        if (curUser == null || userDao.find((curUser).getId()) == null) {
            page = "/jsps/login.jsp";
        } else {
            RoleDao roleDao = (RoleDaoImpl) daoFactory.getDao(Role.class);
            List<Role> roles = roleDao.getAll();
            request.setAttribute("roles", roles);
            roleDao.close();
        }

        userDao.close();
        return page;
    }
}
