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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Point point = (Point) o;

        if (value != point.value) return false;
        return name == point.name;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", value=" + value;
    }
}
