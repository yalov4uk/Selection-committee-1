package by.training.nc.dev3.commands.show_list;

import by.training.nc.dev3.dao.FacultyDaoImpl;
import by.training.nc.dev3.dao.RegisteredUserDaoImpl;
import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.RegisteredUser;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.FacultyDao;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
public class ShowRegisteredUsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/show_list/registeredUsers.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl) daoFactory.getDao(RegisteredUser.class);
        FacultyDao facultyDao = (FacultyDaoImpl) daoFactory.getDao(Faculty.class);

        List<RegisteredUser> registeredUsers = registeredUserDao.getAll();
        registeredUsers.forEach(registeredUser -> {
            registeredUser.setFaculty(facultyDao.find(registeredUser.getFacultyId()));
            registeredUser.setUser(userDao.find(registeredUser.getUserId()));
        });

        request.setAttribute("registeredUsers", registeredUsers);
        facultyDao.close();
        registeredUserDao.close();
        userDao.close();
        return page;
    }
}
