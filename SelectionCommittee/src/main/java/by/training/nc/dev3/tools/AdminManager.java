/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.RegisteredUser;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.IAdminManager;
import by.training.nc.dev3.iterfaces.IInOutManager;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;
import by.training.nc.dev3.iterfaces.dao.StatementDao;

/**
 * @author Valera Yalov4uk
 */
public class AdminManager implements IAdminManager {

    private User admin;

    public void createStatement(RegisteredUserDao registeredUserDao, StatementDao
            statementDao, IInOutManager inOutManager) {
        int userId = inOutManager.inputInteger("Enter registered to faculty user id", 0, 10000000);
        for (RegisteredUser registeredUser : registeredUserDao.getAll()) {
            if (registeredUser.getUserId() == userId) {
                Statement statement = statementDao.persist(new Statement(userId, registeredUser.getFacultyId()));
                registeredUserDao.deleteByUserId(userId);
                inOutManager.outputString("Success");
                return;
            }
        }
        inOutManager.outputString("No registered to faculty student with this id");
    }

    public AdminManager() {
    }

    public AdminManager(User admin) {
        this.admin = admin;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
