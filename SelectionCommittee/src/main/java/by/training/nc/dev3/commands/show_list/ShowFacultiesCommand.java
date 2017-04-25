package by.training.nc.dev3.commands.show_list;

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
public class ShowFacultiesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/show_list/faculties.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        List<Faculty> faculties = loadReferences(daoFactory, userDao);
        request.setAttribute("faculties", faculties);
        userDao.close();
        return page;
    }

    private List<Faculty> loadReferences(DaoFactory daoFactory, UserDao userDao) {
        FacultyDao facultyDao = (FacultyDaoImpl) daoFactory.getDao(Faculty.class);
        RequiredSubjectDao requiredSubjectDao = (RequiredSubjectDaoImpl) daoFactory.getDao(RequiredSubject.class);
        RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl) daoFactory.getDao(RegisteredUser.class);
        SubjectNameDao subjectNameDao = (SubjectNameDaoImpl) daoFactory.getDao(SubjectName.class);

        List<Faculty> faculties = facultyDao.getAll();
        faculties.forEach(faculty -> {
            List<RequiredSubject> requiredSubjects = requiredSubjectDao.findAllByFacultyId(faculty.getId());
            List<SubjectName> subjectNames = new LinkedList<>();
            if (requiredSubjects != null) {
                requiredSubjects.forEach(requiredSubject -> subjectNames.add(subjectNameDao.find(requiredSubject.getSubjectNameId())));
            }
            faculty.setRequiredSubjects(subjectNames);

            List<User> users = new LinkedList<>();
            List<RegisteredUser> registeredUsers = registeredUserDao.findRegisteredUserByFacultyId(faculty.getId());
            if (registeredUsers != null) {
                registeredUsers.forEach(registeredUser -> users.add(userDao.find(registeredUser.getUserId())));
            }
            faculty.setRegisteredEntrants(users);
        });

        facultyDao.close();
        requiredSubjectDao.close();
        registeredUserDao.close();
        subjectNameDao.close();

        return faculties;
    }
}
