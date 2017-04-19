package by.training.nc.dev3.commands.show_list;

import by.training.nc.dev3.dao.RoleDaoImpl;
import by.training.nc.dev3.entities.Role;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.RoleDao;
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
        String page = "/jsps/show_list/roles.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();

        RoleDao roleDao = (RoleDaoImpl) daoFactory.getDao(Role.class);
        List<Role> roles = roleDao.getAll();
        request.setAttribute("roles", roles);
        roleDao.close();
        return page;
    }
}
