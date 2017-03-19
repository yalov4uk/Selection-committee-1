/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Human;

/**
 *
 * @author Valera Yalov4uk
 */
public class Admin extends Human {

    private String login;
    private String password;

    public Admin() {
        super();
        this.login = "admin";
        this.password = "admin";
    }

    public Admin(String name) {
        super(name);
        this.login = "admin";
        this.password = "admin";
    }
}
