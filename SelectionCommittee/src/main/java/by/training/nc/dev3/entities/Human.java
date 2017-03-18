/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.interfaces.IdIncrement;

/**
 *
 * @author Valera Yalov4uk
 */
public abstract class Human implements IdIncrement {

    protected int id;
    protected String name;
    private static int i = 0;

    public Human() {
    }

    public Human(String name) {
        this.id = i++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" + "id=" + id + ", name=" + name + '}';
    }
}
