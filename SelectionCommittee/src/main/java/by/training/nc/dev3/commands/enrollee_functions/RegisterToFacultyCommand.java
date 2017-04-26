package by.training.nc.dev3.commands.enrollee_functions;

import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.*;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;
import by.training.nc.dev3.localosation.Bundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class RegisterToFacultyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/index.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();

        User curUser = (User) request.getSession().getAttribute("user");
        page = registerToFaculty(daoFactory, page, curUser, request);
        return page;
    }

    private String registerToFaculty(DaoFactory daoFactory, String page, User curUser, HttpServletRequest request) {
        FacultyDao facultyDao = (FacultyDaoImpl) daoFactory.getDao(Faculty.class);
        RequiredSubjectDao requiredSubjectDao = (RequiredSubjectDaoImpl) daoFactory.getDao(RequiredSubject.class);
        RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl) daoFactory.getDao(RegisteredUser.class);
        SubjectNameDao subjectNameDao = (SubjectNameDaoImpl) daoFactory.getDao(SubjectName.class);
        SubjectDao subjectDao = (SubjectDaoImpl) daoFactory.getDao(Subject.class);

        List<SubjectName> subjectNames = new LinkedList<>();

        Faculty faculty = facultyDao.findByName(request.getParameter("name"));
        if (faculty == null) {
            ResourceBundle resourceBundle = Bundle.getResourceBundle(request);
            String FACULTY_NULL = resourceBundle.getString("FACULTY_NULL");
            request.setAttribute("errorMessage", FACULTY_NULL);
            page = "/jsps/error/error.jsp";
        } else {
            if (registeredUserDao.findRegisteredUserByIds(curUser.getId(), faculty.getId()) != null) {
                ResourceBundle resourceBundle = Bundle.getResourceBundle(request);
                String YOU_ALREADY_REGISTERED = resourceBundle.getString("YOU_ALREADY_REGISTERED");
                request.setAttribute("errorMessage", YOU_ALREADY_REGISTERED);
                page = "/jsps/error/error.jsp";
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
                page = "/jsps/functions/registerToFaculty.jsp";
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
