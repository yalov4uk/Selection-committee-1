/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.initializers.BoneCPConf;
import by.training.nc.dev3.iterfaces.*;
import by.training.nc.dev3.iterfaces.dao.*;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.tools.*;
import com.jolbox.bonecp.BoneCP;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class Server implements IServer, IServerSubMenu {

    private BoneCP pool;
    private DaoFactory daoFactory;

    private IAdminManager adminManager;
    private IEnrolleeManager enrolleeManager;
    private IInOutManager inOutManager;
    private ISystemManager systemManager;
    private IRegisterManager registerManager;
    private ILoginManager loginManager;

    public void main() {
        String message = "--------------------------------------\n" +
                "1. Register.\n2. Login.\n0. Exit.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 2)) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                default:
                    pool.close();
                    System.exit(0);
            }
        }
    }

    public void menuAdmin() {
        String message = "--------------------------------------\n" +
                "1. Show users.\n2. Show roles, subjects, subject names.\n3. Show faculties.\n4. Show statements.\n" +
                "5. Create statement.\n6. Calculate and show entrants.\n0. Back.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 6)) {
                case 1:
                    UserDao userDao = (UserDaoImpl)daoFactory.getDao(User.class);
                    inOutManager.outputList(userDao.getAll(), "Users:");
                    userDao.close();
                    break;
                case 2:
                    RoleDao roleDao = (RoleDaoImpl)daoFactory.getDao(Role.class);
                    inOutManager.outputList(roleDao.getAll(), "Roles:");
                    roleDao.close();

                    SubjectDao subjectDao = (SubjectDaoImpl)daoFactory.getDao(Subject.class);
                    inOutManager.outputList(subjectDao.getAll(), "Subjects:");
                    subjectDao.close();

                    SubjectNameDao subjectNameDao = (SubjectNameDaoImpl)daoFactory.getDao(SubjectName.class);
                    inOutManager.outputList(subjectNameDao.getAll(), "SubjectNames:");
                    subjectNameDao.close();
                    break;
                case 3:
                    FacultyDao facultyDao = (FacultyDaoImpl)daoFactory.getDao(Faculty.class);
                    inOutManager.outputList(facultyDao.getAll(), "Faculties:");
                    facultyDao.close();
                    break;
                case 4:
                    StatementDao statementDao = (StatementDaoImpl)daoFactory.getDao(Statement.class);
                    inOutManager.outputList(statementDao.getAll(), "Statements:");
                    statementDao.close();
                    break;
                case 5:
                    RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl)daoFactory.getDao(RegisteredUser.class);
                    statementDao = (StatementDaoImpl)daoFactory.getDao(Statement.class);
                    adminManager.createStatement(registeredUserDao, statementDao, inOutManager);
                    registeredUserDao.close();
                    statementDao.close();
                    break;
                case 6:
                    List<Statement> statements = loadReferences();
                    inOutManager.outputResultEntrants(systemManager.calculate(statements));
                    break;
                default:
                    main();
            }
        }
    }

    public void menuEnrollee() {
        String message = "--------------------------------------\n" +
                "1. Show faculties.\n2. Register to faculty.\n0. Back.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 2)) {
                case 1:
                    FacultyDao facultyDao = (FacultyDaoImpl)daoFactory.getDao(Faculty.class);
                    inOutManager.outputList(facultyDao.getAll(), "Faculties:");
                    facultyDao.close();
                    break;
                case 2:
                    registerToFaculty();
                    break;
                default:
                    main();
            }
        }
    }

    private void register() {
        UserDao userDao = (UserDaoImpl)daoFactory.getDao(User.class);
        User curUser = registerManager.register(userDao.getAll(), inOutManager);
        enrolleeManager.setEnrollee(userDao.persist(curUser));
        userDao.close();
        menuEnrollee();
    }

    private void login() {
        UserDao userDao = (UserDaoImpl)daoFactory.getDao(User.class);
        User curUser = loginManager.login(userDao, inOutManager);
        userDao.close();
        if (curUser != null) {
            if (curUser.getRoleId() == 1) {
                enrolleeManager.setEnrollee(curUser);
                menuEnrollee();
            } else {
                adminManager.setAdmin(curUser);
                menuAdmin();
            }
        }
    }

    private void registerToFaculty() {
        FacultyDao facultyDao = (FacultyDaoImpl)daoFactory.getDao(Faculty.class);
        RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl)daoFactory.getDao(RegisteredUser.class);
        RequiredSubjectDao requiredSubjectDao = (RequiredSubjectDaoImpl)daoFactory.getDao(RequiredSubject.class);
        SubjectDao subjectDao = (SubjectDaoImpl)daoFactory.getDao(Subject.class);
        SubjectNameDao subjectNameDao = (SubjectNameDaoImpl)daoFactory.getDao(SubjectName.class);

        String facultyName = inOutManager.inputString("Enter faculty name");
        Faculty faculty = facultyDao.findByName(facultyName);
        if (faculty != null && enrolleeManager.registerEnrollee(faculty, inOutManager, registeredUserDao,
                requiredSubjectDao, subjectDao, subjectNameDao)) {
            inOutManager.outputString("Success");
            return;
        }
        facultyDao.close();
        registeredUserDao.close();
        requiredSubjectDao.close();
        subjectDao.close();
        subjectNameDao.close();

        inOutManager.outputString("Incorrect faculty name");
    }

    private List<Statement> loadReferences() {
        StatementDao statementDao = (StatementDaoImpl)daoFactory.getDao(Statement.class);
        FacultyDao facultyDao = (FacultyDaoImpl)daoFactory.getDao(Faculty.class);
        UserDao userDao = (UserDaoImpl)daoFactory.getDao(User.class);
        RequiredSubjectDao requiredSubjectDao = (RequiredSubjectDaoImpl)daoFactory.getDao(RequiredSubject.class);
        SubjectNameDao subjectNameDao = (SubjectNameDaoImpl)daoFactory.getDao(SubjectName.class);
        SubjectDao subjectDao = (SubjectDaoImpl)daoFactory.getDao(Subject.class);

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

    public Server() {
        try {
            pool = new BoneCP(BoneCPConf.initialize());
        } catch (SQLException e) {
            throw new DaoUncheckedException("BoneCP init error");
        }

        adminManager = new AdminManager();
        enrolleeManager = new EnrolleeManager();
        inOutManager = new InOutManager();
        systemManager = new SystemManager();
        registerManager = new RegisterManager();
        loginManager = new LoginManager();

        daoFactory = new DaoFactoryImpl(pool);
    }
}
