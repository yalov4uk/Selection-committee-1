/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.tools.AdminManager;
import by.training.nc.dev3.tools.EnrolleeManager;
import by.training.nc.dev3.tools.MenuManager;
import by.training.nc.dev3.tools.SerializeManager;
import by.training.nc.dev3.tools.SystemManager;
import java.util.GregorianCalendar;

/**
 *
 * @author Valera Yalov4uk
 */
public class Server {

    private DataBase db;

    private AdminManager<Admin> adminManager;
    private EnrolleeManager enrolleeManager;
    private MenuManager menuManager;
    private SerializeManager<DataBase> serializeManager;
    private SystemManager systemManager;

    public void main() {
        String message = "admin - 0, enrollee - 1, calendar - 2, exit - exit";
        while (true) {
            switch (menuManager.enterValue(message, 0, 2)) {
                case 0:
                    createAdmin();
                    break;
                case 1:
                    createEnrollee();
                    break;
                case 2:
                    gregarianCalendar();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void menuAdmin() {
        String message = "show all - 0, register enrollee by id - 1, "
                + "calculate and show - 2, save - 3, load - 4, back - exit";
        while (true) {
            switch (menuManager.enterValue(message, 0, 4)) {
                case 0:
                    fullOutput();
                    break;
                case 1:
                    registerEnrollee();
                    break;
                case 2:
                    menuManager.outputResultEntrants(systemManager.calculate(
                            db.getStatements()));
                    break;
                case 3:
                    serializeManager.serialize(db);
                    break;
                case 4:
                    db = serializeManager.deserilize();
                    break;
                default:
                    main();
            }
        }
    }

    private void menuEnrollee() {
        String message = "Show faculties - 0, register to faculty - 1, back - exit";
        while (true) {
            switch (menuManager.enterValue(message, 0, 1)) {
                case 0:
                    menuManager.outputList(db.getFaculties(), "Faculties:");
                    break;
                case 1:
                    registerToFaculty();
                    break;
                default:
                    main();
            }
        }
    }

    private void createAdmin() {
        Admin admin = new Admin(menuManager.inputString("Enter you name"));
        adminManager.setAdmin(admin);
        db.getAdmins().add(admin);
        menuAdmin();
    }

    private void createEnrollee() {
        Enrollee enrollee = new Enrollee(menuManager.inputString("Enter you name"));
        enrolleeManager.setEnrollee(enrollee);
        db.getEntrants().add(enrollee);
        menuEnrollee();
    }

    private void gregarianCalendar() {
        System.out.println("Today: " + new GregorianCalendar().getTime());
    }

    private void fullOutput() {
        menuManager.outputList(db.getEntrants(), "Entrants:");
        menuManager.outputList(db.getAdmins(), "Admins:");
        menuManager.outputList(db.getPoints(), "Points:");
        menuManager.outputList(db.getFaculties(), "Faculties:");
        menuManager.outputList(db.getStatements(), "Statements:");
    }

    private void registerEnrollee() {
        Statement statement = adminManager.registerStatement(
                db.getFaculties(), menuManager.enterValue(
                "Enter enrolle id", 0, 10000000));
        if (statement == null) {
            System.out.println("No student with this id");
        } else {
            db.getStatements().add(statement);
            System.out.println("Success");
        }
    }

    private void registerToFaculty() {
        String facultyName = menuManager.inputString("Enter faculty name");
        for (Faculty faculty : db.getFaculties()) {
            if (faculty.getName().toString().equalsIgnoreCase(facultyName)) {
                enrolleeManager.register(faculty);
                System.out.println("Success");
            }
        }
    }

    public Server() {
        db = new DataBase();
        serverInit();

    }

    public Server(DataBase db) {
        this.db = db;
        serverInit();
    }

    private void serverInit() {
        adminManager = new AdminManager<>();
        enrolleeManager = new EnrolleeManager();
        menuManager = new MenuManager();
        serializeManager = new SerializeManager<>();
        systemManager = new SystemManager();
    }

    /**
     *
     * @return
     */
    public AdminManager<Admin> getAdminManager() {
        return adminManager;
    }

    /**
     *
     * @param adminManager
     */
    public void setAdminManager(AdminManager<Admin> adminManager) {
        this.adminManager = adminManager;
    }

    public EnrolleeManager getEnrolleeManager() {
        return enrolleeManager;
    }

    public void setEnrolleeManager(EnrolleeManager enrolleeManager) {
        this.enrolleeManager = enrolleeManager;
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    public void setMenuManager(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public SerializeManager<DataBase> getSerializeManager() {
        return serializeManager;
    }

    public void setSerializeManager(SerializeManager<DataBase> serializeManager) {
        this.serializeManager = serializeManager;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(SystemManager systemManager) {
        this.systemManager = systemManager;
    }
}
