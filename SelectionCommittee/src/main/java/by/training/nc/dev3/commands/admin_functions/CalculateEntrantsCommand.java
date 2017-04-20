package by.training.nc.dev3.commands.admin_functions;

import by.training.nc.dev3.comparators.StatementComparatorByAverageScore;
import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.*;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
public class CalculateEntrantsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/showPassEntrants.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        StatementDao statementDao = (StatementDaoImpl) daoFactory.getDao(Statement.class);

        List<Statement> statements = loadReferences(daoFactory);

        Map<String, List<Statement>> simpleMap = new HashMap<>();
        statements.forEach((statement) -> {
            String facultyName = statement.getFaculty().getName();
            if (!simpleMap.containsKey(facultyName)) {
                simpleMap.put(facultyName, new ArrayList<>());
            }
            simpleMap.get(facultyName).add(statement);
        });
        simpleMap.values().forEach((list) -> {
            //Collections.sort(list);                               //comparable
            list.sort(new StatementComparatorByAverageScore());     //comparator
        });

        request.setAttribute("passEntrants", simpleMap);
        statementDao.close();
        return page;
    }

    private List<Statement> loadReferences(DaoFactory daoFactory) {
        StatementDao statementDao = (StatementDaoImpl) daoFactory.getDao(Statement.class);
        FacultyDao facultyDao = (FacultyDaoImpl) daoFactory.getDao(Faculty.class);
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);
        RequiredSubjectDao requiredSubjectDao = (RequiredSubjectDaoImpl) daoFactory.getDao(RequiredSubject.class);
        SubjectNameDao subjectNameDao = (SubjectNameDaoImpl) daoFactory.getDao(SubjectName.class);
        SubjectDao subjectDao = (SubjectDaoImpl) daoFactory.getDao(Subject.class);

        List<Statement> statements = statementDao.getAll();
        for (Statement statement : statements) {
            int facultyId = statement.getFacultyId();
            int userId = statement.getUserId();
            statement.setFaculty(facultyDao.find(facultyId));
            statement.setUser(userDao.find(userId));

            List<SubjectName> subjectNames = new ArrayList<>();
            List<RequiredSubject> requiredSubjects = requiredSubjectDao.findAllByFacultyId(facultyId);
            for (RequiredSubject requiredSubject : requiredSubjects) {
                subjectNames.add(subjectNameDao.find(requiredSubject.getSubjectNameId()));
            }
            statement.getFaculty().setRequiredSubjects(subjectNames);

            List<Subject> subjects = subjectDao.findAllByUserId(userId);
            statement.getUser().setSubjects(subjects);

            for (Subject subject : subjects) {
                subject.setSubjectName(subjectNameDao.find(subject.getSubjectNameId()));
            }
        }
        statementDao.close();
        facultyDao.close();
        userDao.close();
        requiredSubjectDao.close();
        subjectNameDao.close();
        subjectDao.close();

        return statements;
    }
}
