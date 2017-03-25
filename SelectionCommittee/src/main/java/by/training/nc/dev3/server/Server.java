/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
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
                "1. Register.\n2. Login.\n3. Gregorian calendar.\n0. Exit.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 3)) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    gregorianCalendar();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public void menuAdmin() {
        String message = "--------------------------------------\n" +
                "1. Show admins.\n2. Show entrants.\n3. Show faculties.\n4. Show statements.\n5. Show points.\n" +
                "6. Create statement.\n7. Calculate and show entrants.\n8. Save.\n9. Load.\n0. Back.\n" +
                "--------------------------------------";
        while (true) {
            switch (inOutManager.inputInteger(message, 0, 9)) {
                case 1:
                    inOutManager.outputList(db.getAdmins(), "Admins:");
                    break;
                case 2:
                    inOutManager.outputList(db.getEntrants(), "Entrants:");
                    break;
                case 3:
                    inOutManager.outputList(db.getFaculties(), "Faculties:");
                    break;
                case 4:
                    inOutManager.outputList(db.getStatements(), "Statements:");
                    break;
                case 5:
                    inOutManager.outputList(db.getPoints(), "Points:");
                    break;
                case 6:
                    createStatement();
                    break;
                case 7:
                    inOutManager.outputResultEntrants(systemManager.calculate(db.getStatements()));
                    break;
                case 8:
                    if (serializeManager.serialize(db)) {
                        inOutManager.outputString("Success");
                    } else {
                        inOutManager.outputString("Error");
                    }
                    break;
                case 9:
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
        Human curUser = registerManager.register(db.getHumans(), inOutManager);
        enrolleeManager.setEnrollee((Enrollee) curUser);
        db.getEntrants().add(curUser);
        curUser.goNextMenu(this);
    }

    private void login() {
        Human curUser = loginManager.login(db.getHumans(), inOutManager);
        if (curUser != null) {
            if (curUser instanceof Enrollee) {
                enrolleeManager.setEnrollee((Enrollee) curUser);
            } else {
                adminManager.setAdmin((Admin) curUser);
            }
            curUser.goNextMenu(this);
        }
    }

    private void gregorianCalendar() {
        inOutManager.outputString("Today: " + new GregorianCalendar().getTime());
    }

    private void createStatement() {
        Statement statement = adminManager.createStatement(
                db.getFaculties(), inOutManager.inputInteger("Enter enrolle id", 0, 10000000));
        if (statement == null) {
            inOutManager.outputString("No student with this id");
        } else {
            db.getStatements().add(statement);
            inOutManager.outputString("Success");
        }
    }

    private void registerToFaculty() {
        String facultyName = inOutManager.inputString("Enter faculty name");
        for (Faculty faculty : db.getFaculties()) {
            if (faculty.getName().toString().equalsIgnoreCase(facultyName)) {
                enrolleeManager.registerEnrollee(faculty, inOutManager);
                inOutManager.outputString("Success");
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
