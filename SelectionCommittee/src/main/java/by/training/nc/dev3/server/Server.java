/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.*;
import by.training.nc.dev3.tools.*;

import java.util.GregorianCalendar;

/**
 * @author Valera Yalov4uk
 */
public class Server implements IServer, IServerSubMenu {

    private DataBase db;

    private IAdminManager adminManager;
    private IEnrolleeManager enrolleeManager;
    private IInOutManager inOutManager;
    private ISerializeManager<DataBase> serializeManager;
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
                    System.exit(0);
            }
        }
    }

    public void menuAdmin() {
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

    public void menuEnrollee() {
        String message = "--------------------------------------\n" +
                "1. Show faculties.\n2. Register to faculty.\n0. Back.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 2)) {
                case 1:
                    inOutManager.outputList(db.getFaculties(), "Faculties:");
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
        User curUser = registerManager.register(db.getUsers(), inOutManager);
        enrolleeManager.setEnrollee(curUser);
        db.getUsers().add(curUser);
        menuEnrollee();
    }

    private void login() {
        User curUser = loginManager.login(db.getUsers(), inOutManager);
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

    private void registerToFaculty() {
        String facultyName = inOutManager.inputString("Enter faculty name");
        for (Faculty faculty : db.getFaculties()) {
            if (faculty.getName().toString().equalsIgnoreCase(facultyName)) {
                if (enrolleeManager.registerEnrollee(faculty, inOutManager, db)) {
                    inOutManager.outputString("Success");
                    for (Subject subject : enrolleeManager.getEnrollee().getSubjects()) {
                        if (!db.getSubjects().contains(subject)) {
                            db.getSubjects().add(subject);
                        }
                    }
                }
                return;
            }
        }
        inOutManager.outputString("Incorrect faculty name");
    }

    private void serverInit() {
        adminManager = new AdminManager();
        enrolleeManager = new EnrolleeManager();
        inOutManager = new InOutManager();
        serializeManager = new SerializeManager();
        systemManager = new SystemManager();
        registerManager = new RegisterManager();
        loginManager = new LoginManager();
    }

    public Server() {
        db = new DataBase();
        serverInit();

    }

    public Server(DataBase db) {
        this.db = db;
        serverInit();
    }

    /**
     * @return
     */
    public IAdminManager getAdminManager() {
        return adminManager;
    }

    /**
     * @param adminManager
     */
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

    public ISerializeManager<DataBase> getSerializeManager() {
        return serializeManager;
    }

    public void setSerializeManager(ISerializeManager<DataBase> serializeManager) {
        this.serializeManager = serializeManager;
    }

    public ISystemManager getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(ISystemManager systemManager) {
        this.systemManager = systemManager;
    }
}
