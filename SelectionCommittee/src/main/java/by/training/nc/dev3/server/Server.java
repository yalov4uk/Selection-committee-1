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
        String message = "admin - 0, enrollee - 1, exit - exit";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 1)) {
                case 0:
                    Admin admin = new Admin(menuManager.enterName());                
                    adminManager.setAdmin(admin);
                    db.getAdmins().add(admin);
                    youAdmin();
                    break;
                case 1:
                    Enrollee enrollee = new Enrollee(menuManager.enterName());
                    enrolleeManager.setEnrollee(enrollee);
                    db.getEntrants().add(enrollee);
                    youEnrollee();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void youAdmin() {
        String message = "show all - 0, register enrollee by id - 1, back - exit";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 1)) {
                case 0:
                    /*menuManager.writeForAdmin(db.getEntrants(), "Entrants:");
                    menuManager.writeForAdmin(db.getAdmins(), "Admins:");
                    menuManager.writeForAdmin(db.getPoints(), "Points:");
                    menuManager.writeForAdmin(db.getFaculties(), "Faculties:");*/
                    menuManager.writeForAdmin(db.getStatements(), "Statements:"); //Statements include all previous information
                    break;
                case 1:
                    Statement statement = adminManager.registerStatement(
                            db.getFaculties(), menuManager.enterValue(
                                    "Enter enrolle id", 0, 10000000));
                    if (statement == null){
                        System.out.println("No student with this id");
                    } else{
                        db.getStatements().add(statement);
                    }
                    break;
                default:
                    main();
            }
        }
    }
    
    private void youEnrollee(){
        
    }

    public Server() {
        db = new DataBase();
        serverInit();
        
    }

    public Server(DataBase db) {
        this.db = db;
        serverInit();
    }
    
    private void serverInit(){
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
