/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.server;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.tools.AdminManager;
import by.training.nc.dev3.tools.EnrolleeManager;
import by.training.nc.dev3.tools.MenuManager;
import by.training.nc.dev3.tools.SerializeManager;
import by.training.nc.dev3.tools.SystemManager;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class Server {

    private DataBase db;

    private AdminManager adminManager;
    private EnrolleeManager enrolleeManager;
    private MenuManager menuManager;
    private SerializeManager serializeManager;
    private SystemManager systemManager;

    public void main() {
        String message = "admin - 0, enrollee - 1, calendar - 2, exit - exit";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 2)) {
                case 0:
                    Admin admin = new Admin(menuManager.inputString("Enter you name"));
                    adminManager.setAdmin(admin);
                    db.getAdmins().add(admin);
                    youAdmin();
                    break;
                case 1:
                    Enrollee enrollee = new Enrollee(menuManager.inputString("Enter you name"));
                    enrolleeManager.setEnrollee(enrollee);
                    db.getEntrants().add(enrollee);
                    youEnrollee();
                    break;
                case 2:
                    System.out.println("Today: " + new GregorianCalendar().getTime());
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void youAdmin() {
        String message = "show all - 0, register enrollee by id - 1, "
                + "calculate and show - 2, save - 3, load - 4, back - exit";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 4)) {
                case 0:
                    menuManager.outputList(db.getEntrants(), "Entrants:");
                    menuManager.outputList(db.getAdmins(), "Admins:");
                    menuManager.outputList(db.getPoints(), "Points:");
                    menuManager.outputList(db.getFaculties(), "Faculties:");
                    menuManager.outputList(db.getStatements(), "Statements:");
                    break;
                case 1:
                    Statement statement = adminManager.registerStatement(
                            db.getFaculties(), menuManager.enterValue(
                            "Enter enrolle id", 0, 10000000));
                    if (statement == null) {
                        System.out.println("No student with this id");
                    } else {
                        db.getStatements().add(statement);
                        System.out.println("Success");
                    }
                    break;
                case 2:
                    menuManager.writeResultEntrants(systemManager.calculate(db.getStatements()));
                    break;
                case 3:
                    serializeManager.serialize(db);
                    break;
                case 4:
                    db = (DataBase) serializeManager.deserilize();
                    break;
                default:
                    main();
            }
        }
    }

    private void youEnrollee() {
        String message = "Show faculties - 0, register to faculty - 1, back - exit";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 1)) {
                case 0:
                    menuManager.outputList(db.getFaculties(), "Faculties:");
                    break;
                case 1:
                    String facultyName = menuManager.inputString("Enter faculty name");
                    for (Faculty faculty : db.getFaculties()) {
                        if (faculty.getName().toString().equalsIgnoreCase(facultyName)) {
                            enrolleeManager.register(faculty);
                        }
                    }
                    break;
                default:
                    main();
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
        adminManager = new AdminManager();
        enrolleeManager = new EnrolleeManager();
        menuManager = new MenuManager();
        serializeManager = new SerializeManager();
        systemManager = new SystemManager();
    }

    public AdminManager getAdminManager() {
        return adminManager;
    }

    public void setAdminManager(AdminManager adminManager) {
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

    public SerializeManager getSerializeManager() {
        return serializeManager;
    }

    public void setSerializeManager(SerializeManager serializeManager) {
        this.serializeManager = serializeManager;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(SystemManager systemManager) {
        this.systemManager = systemManager;
    }
}
