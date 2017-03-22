/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.enums.PointName;

/**
 * @author Valera Yalov4uk
 */
public class Certificate extends Point {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    public Certificate() {
        super(PointName.CERTIFICATE);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Certificate{" + super.toString() + ", count=" + count + '}';
    }
}
