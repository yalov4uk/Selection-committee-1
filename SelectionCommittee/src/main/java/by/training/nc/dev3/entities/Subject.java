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

    public Subject() {
        super();
    }

    public Subject(PointName name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + ", value=" + value + '}';
    }
}