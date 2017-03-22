/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.enums.PointName;

/**
 *
 * @author Valera Yalov4uk
 */
public class Subject extends Point {

    private static int count = 0;
    private static final long serialVersionUID = 1L;

    public Subject() {
        super();
        count++;
    }

    public Subject(PointName name) {
        super(name);
        count++;
    }

    @Override
    public String toString() {
        return "Subject{" + super.toString() + ", count=" + count + '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static int getCount() {
        return count;
    }
}
