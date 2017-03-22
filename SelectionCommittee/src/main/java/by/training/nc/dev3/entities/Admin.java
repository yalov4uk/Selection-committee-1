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
    
    private static int count = 0;

    public Admin() {
        super();
        this.login = "admin";
        this.password = "admin";
        count++;
    }

    public Admin(String name) {
        super(name);
        this.login = "admin";
        this.password = "admin";
        count++;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 71 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (!((Human) this).equals((Human) obj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() + "login=" + login + ", password=" + password + ", count=" + count + '}';
    }

    public static int getCount() {
        return count;
    }
}
