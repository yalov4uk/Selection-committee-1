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

    private List<Enrollee> entrants = new ArrayList();
    private List<Admin> admins = new ArrayList();
    private List<Point> points = new ArrayList();
    private List<Faculty> faculties = new ArrayList();
    private List<Statement> statements = new ArrayList();

    private AdminManager adminManager;
    private EnrolleeManager enrolleeManager;
    private MenuManager menuManager;
    private SerializeManager serializeManager;
    private SystemManager systemManager;

    public void main() {
        String message = "admin - 0, enrollee - 1";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 1)) {
                case 0:
                    adminManager = new AdminManager(new Admin());
                    youAdmin();
                    break;
                case 1:
                    enrolleeManager = new EnrolleeManager(new Enrollee("temp1"));
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void youAdmin() {
        String message = "show all - 0, register enrollee by id/name";
        while (true) {
            switch ((int) menuManager.enterValue(message, 0, 1)) {
                case 0:
                    adminManager = new AdminManager(new Admin());
                    youAdmin();
                    break;
                case 1:
                    enrolleeManager = new EnrolleeManager(new Enrollee("temp1"));
                    break;
                default:
                    System.exit(0);
            }
        }
    }

}
