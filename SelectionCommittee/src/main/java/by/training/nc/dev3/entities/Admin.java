/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Human;

/**
 * @author Valera Yalov4uk
 */
public class Admin extends Human {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    public Admin() {
        super();
        count++;
    }

    public Admin(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() + ", count=" + count + '}';
    }
}
