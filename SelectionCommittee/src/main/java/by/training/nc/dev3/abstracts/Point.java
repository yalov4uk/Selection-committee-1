/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.abstracts;

import by.training.nc.dev3.enums.PointName;

/**
 * @author Valera Yalov4uk
 */
public abstract class Point extends Entity {

    private static final long serialVersionUID = 1L;

    protected PointName name;
    protected int value;

    public Point() {
        super();
    }

    public Point(PointName name) {
        super();
        this.name = name;
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
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 73 * hash + this.value;
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
        final Point other = (Point) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", value=" + value;
    }
}
