package by.training.nc.dev3.commands;

import by.training.nc.dev3.dao.RegisteredUserDaoImpl;
import by.training.nc.dev3.dao.SubjectDaoImpl;
import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.RegisteredUser;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;
import by.training.nc.dev3.iterfaces.dao.SubjectDao;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class RegisterToFacultyPostCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/index.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        User curUser = (User) request.getSession().getAttribute("user");
        Faculty faculty = (Faculty) request.getSession().getAttribute("faculty");
        if (curUser == null || userDao.find((curUser).getId()) == null || faculty == null) {
            page = "/jsps/login.jsp";
        } else {
            RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl) daoFactory.getDao(RegisteredUser.class);
            SubjectDao subjectDao = (SubjectDaoImpl) daoFactory.getDao(Subject.class);

            int value = Integer.parseInt(request.getParameter("value"));
            int subjectNameId = Integer.parseInt(request.getParameter("subjectNameId"));

            subjectDao.persist(new Subject(value, subjectNameId, curUser.getId()));

            registeredUserDao.persist(new RegisteredUser(faculty.getId(), curUser.getId()));
            request.getSession().removeAttribute("faculty");

            registeredUserDao.close();
        }

        userDao.close();
        return page;
    }
}
