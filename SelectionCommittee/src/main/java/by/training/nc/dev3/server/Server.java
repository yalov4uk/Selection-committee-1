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
import java.util.GregorianCalendar;

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
                    inOutManager.outputList(db.getUsers(), "Users:");
                    break;
                case 2:
                    inOutManager.outputList(db.getRoles(), "Roles:");
                    inOutManager.outputList(db.getSubjects(), "Subjects:");
                    inOutManager.outputList(db.getSubjectNames(), "SubjectNames:");
                    break;
                case 3:
                    inOutManager.outputList(db.getFaculties(), "Faculties:");
                    break;
                case 4:
                    inOutManager.outputList(db.getStatements(), "Statements:");
                    break;
                case 5:
                    createStatement();
                    break;
                case 6:
                    inOutManager.outputResultEntrants(systemManager.calculate(db.getStatements()));
                    break;
                case 7:
                    if (serializeManager.serialize(db)) {
                        inOutManager.outputString("Success");
                    } else {
                        inOutManager.outputString("Error");
                    }
                    break;
                case 8:
                    db = serializeManager.deserialize();
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

    private void gregorianCalendar() {
        inOutManager.outputString("Today: " + new GregorianCalendar().getTime());
    }

    private void createStatement() {
        Statement statement = adminManager.createStatement(
                db.getFaculties(), inOutManager.inputInteger("Enter registered to faculty user id", 0, 10000000));
        if (statement == null) {
            inOutManager.outputString("No registered to faculty student with this id");
        } else {
            db.getStatements().add(statement);
            inOutManager.outputString("Success");
        }
    }

    private void registerToFaculty() throws SQLException {
        String facultyName = inOutManager.inputString("Enter faculty name");
        Faculty faculty = facultyDao.findByName(facultyName);
        if (faculty != null) {
            if (enrolleeManager.registerEnrollee(faculty, inOutManager, registeredUsersDao)) {
                inOutManager.outputString("Success");
                for (Subject subject : enrolleeManager.getEnrollee().getSubjects()) {
                    if (!db.getSubjects().contains(subject)) {
                        db.getSubjects().add(subject);
                    }
                }
            }
            return;
        }
        inOutManager.outputString("Incorrect faculty name");
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
