package by.training.nc.dev3.commands;

import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.*;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class RegisterToFacultyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/index.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        User curUser = (User) request.getSession().getAttribute("user");
        if (curUser == null || userDao.find((curUser).getId()) == null) {
            page = "/jsps/login.jsp";
        } else {
            page = registerToFaculty(daoFactory, page, curUser, request);
        }

        userDao.close();
        return page;
    }

    private String registerToFaculty(DaoFactory daoFactory, String page, User curUser, HttpServletRequest request){
        FacultyDao facultyDao = (FacultyDaoImpl) daoFactory.getDao(Faculty.class);
        RequiredSubjectDao requiredSubjectDao = (RequiredSubjectDaoImpl) daoFactory.getDao(RequiredSubject.class);
        RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl) daoFactory.getDao(RegisteredUser.class);
        SubjectNameDao subjectNameDao = (SubjectNameDaoImpl) daoFactory.getDao(SubjectName.class);
        SubjectDao subjectDao = (SubjectDaoImpl) daoFactory.getDao(Subject.class);

        List<SubjectName> subjectNames = new LinkedList<>();

        Faculty faculty = facultyDao.findByName(request.getParameter("name"));
        if (faculty == null) {
            request.setAttribute("errorMessage", "Faculty == null");
            page = "/jsps/error.jsp";
        } else {
            if (registeredUserDao.findRegisteredUserByIds(curUser.getId(), faculty.getId()) != null) {
                request.setAttribute("errorMessage", "You already registered");
                page = "/jsps/error.jsp";
            } else {
                for (RequiredSubject requiredSubject : requiredSubjectDao.findAllByFacultyId(faculty.getId())) {
                    boolean flag = false;
                    for (Subject subject : subjectDao.findAllByUserId(curUser.getId())) {
                        if (subject.getSubjectNameId() == requiredSubject.getSubjectNameId()) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        subjectNames.add(subjectNameDao.find(requiredSubject.getSubjectNameId()));
                    }
                }
                page = "/jsps/registerToFaculty.jsp";
                request.getSession().setAttribute("faculty", faculty);
                request.setAttribute("subjectNames", subjectNames);
            }
        }
        facultyDao.close();
        requiredSubjectDao.close();
        registeredUserDao.close();
        subjectNameDao.close();
        subjectDao.close();
        return page;
    }
}
