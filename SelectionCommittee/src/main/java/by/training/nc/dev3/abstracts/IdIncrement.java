/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.abstracts;

import java.io.Serializable;

/**
 *
 * @author Valera Yalov4uk
 */
public abstract class IdIncrement implements Serializable {

    private static int i = 0;

    protected int getNextI() {
        return i++;
    }

    public int getObjectCount() {
        return i;
    }
}
