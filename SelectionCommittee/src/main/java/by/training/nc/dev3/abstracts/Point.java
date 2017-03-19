/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.abstracts;

import by.training.nc.dev3.enums.PointName;

/**
 *
 * @author Valera Yalov4uk
 */
public abstract class Point extends IdIncrement {

    protected int id;
    protected PointName name;
    protected int value;

    public Point() {
        i++;
    }

    public Point(PointName name) {
        this.id = i++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PointName getName() {
        return name;
    }

    public void setName(PointName name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Point{" + "id=" + id + ", name=" + name + ", value=" + value + '}';
    }
}
