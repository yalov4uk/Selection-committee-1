/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.initializers.BoneCPConf;
import by.training.nc.dev3.iterfaces.*;
import by.training.nc.dev3.iterfaces.dao.*;
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

    private FacultyDaoImpl facultyDao;
    private RoleDaoImpl roleDao;
    private StatementDaoImpl statementDao;
    private SubjectDaoImpl subjectDao;
    private SubjectNameDaoImpl subjectNameDao;
    private UserDaoImpl userDao;
    private RegisteredUsersDaoImpl registeredUsersDao;
    private RequiredSubjectsDaoImpl requiredSubjectsDao;

    private IAdminManager adminManager;
    private IEnrolleeManager enrolleeManager;
    private IInOutManager inOutManager;
    private ISerializeManager<User> serializeManager;
    private ISystemManager systemManager;
    private IRegisterManager registerManager;
    private ILoginManager loginManager;

    public void main() throws SQLException {
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
                    System.exit(0);
            }
        }
    }

    public void menuAdmin() throws SQLException {
        String message = "--------------------------------------\n" +
                "1. Show users.\n2. Show roles, subjects, subject names.\n3. Show faculties.\n4. Show statements.\n" +
                "5. Create statement.\n6. Calculate and show entrants.\n7. Save.\n8. Load.\n0. Back.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 8)) {
                case 1:
                    inOutManager.outputList(userDao.getAll(), "Users:");
                    break;
                case 2:
                    inOutManager.outputList(roleDao.getAll(), "Roles:");
                    inOutManager.outputList(subjectDao.getAll(), "Subjects:");
                    inOutManager.outputList(subjectNameDao.getAll(), "SubjectNames:");
                    break;
                case 3:
                    inOutManager.outputList(facultyDao.getAll(), "Faculties:");
                    break;
                case 4:
                    inOutManager.outputList(statementDao.getAll(), "Statements:");
                    break;
                case 5:
                    adminManager.createStatement(registeredUsersDao, statementDao, inOutManager);
                    break;
                case 6:
                    List<Statement> statements = loadReferences();
                    inOutManager.outputResultEntrants(systemManager.calculate(statements));
                    break;
                case 7:
                    if (serializeManager.serialize(userDao.getAll().get(0))) {
                        inOutManager.outputString("Success");
                    } else {
                        inOutManager.outputString("Error");
                    }
                    break;
                case 8:
                    enrolleeManager.setEnrollee(serializeManager.deserialize());
                    inOutManager.outputString("Success");
                    break;
                default:
                    main();
            }
        }
    }

    public void menuEnrollee() throws SQLException {
        String message = "--------------------------------------\n" +
                "1. Show faculties.\n2. Register to faculty.\n0. Back.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 2)) {
                case 1:
                    inOutManager.outputList(facultyDao.getAll(), "Faculties:");
                    break;
                case 2:
                    registerToFaculty();
                    break;
                default:
                    main();
            }
        }
    }

    private void register() throws SQLException {
        User curUser = registerManager.register(userDao.getAll(), inOutManager);
        enrolleeManager.setEnrollee(userDao.persist(curUser));
        menuEnrollee();
    }

    private void login() throws SQLException {
        User curUser = loginManager.login(userDao, inOutManager);
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

    private void registerToFaculty() throws SQLException {
        String facultyName = inOutManager.inputString("Enter faculty name");
        Faculty faculty = facultyDao.findByName(facultyName);
        if (faculty != null && enrolleeManager.registerEnrollee(faculty, inOutManager, registeredUsersDao,
                requiredSubjectsDao, subjectDao, subjectNameDao)) {
            inOutManager.outputString("Success");
            return;
        }
        inOutManager.outputString("Incorrect faculty name");
    }

    private List<Statement> loadReferences() throws SQLException {
        List<Statement> statements = statementDao.getAll();
        for (Statement statement : statements) {
            int facultyId = statement.getFacultyId();
            int userId = statement.getUserId();
            statement.setFaculty(facultyDao.find(facultyId));
            statement.setUser(userDao.find(userId));

            List<SubjectName> subjectNames = new ArrayList<>();
            List<RequiredSubject> requiredSubjects = requiredSubjectsDao.findAllByFacultyId(facultyId);
            for (RequiredSubject requiredSubject : requiredSubjects) {
                subjectNames.add(subjectNameDao.find(requiredSubject.getSubjectNameId()));
            }
            statement.getFaculty().setRequiredSubjects(subjectNames);

            List<Subject> subjects = subjectDao.findAllByUserId(userId);
            statement.getUser().setSubjects(subjects);

            for (Subject subject : subjects){
                subject.setSubjectName(subjectNameDao.find(subject.getSubjectNameId()));
            }
        }
        return statements;
    }

    public Server() throws SQLException {
        pool = new BoneCP(BoneCPConf.initialize());

        adminManager = new AdminManager();
        enrolleeManager = new EnrolleeManager();
        inOutManager = new InOutManager();
        serializeManager = new SerializeManager();
        systemManager = new SystemManager();
        registerManager = new RegisterManager();
        loginManager = new LoginManager();

        facultyDao = new FacultyDao(pool.getConnection());
        roleDao = new RoleDao(pool.getConnection());
        statementDao = new StatementDao(pool.getConnection());
        subjectDao = new SubjectDao(pool.getConnection());
        subjectNameDao = new SubjectNameDao(pool.getConnection());
        userDao = new UserDao(pool.getConnection());
        registeredUsersDao = new RegisteredUsersDao(pool.getConnection());
        requiredSubjectsDao = new RequiredSubjectsDao(pool.getConnection());
    }

    public IAdminManager getAdminManager() {
        return adminManager;
    }

    public void setAdminManager(IAdminManager adminManager) {
        this.adminManager = adminManager;
    }

    public IEnrolleeManager getEnrolleeManager() {
        return enrolleeManager;
    }

    public void setEnrolleeManager(IEnrolleeManager enrolleeManager) {
        this.enrolleeManager = enrolleeManager;
    }

    public IInOutManager getInOutManager() {
        return inOutManager;
    }

    public void setInOutManager(IInOutManager inOutManager) {
        this.inOutManager = inOutManager;
    }

    public ISerializeManager<User> getSerializeManager() {
        return serializeManager;
    }

    public void setSerializeManager(ISerializeManager<User> serializeManager) {
        this.serializeManager = serializeManager;
    }

    public ISystemManager getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(ISystemManager systemManager) {
        this.systemManager = systemManager;
    }
}
