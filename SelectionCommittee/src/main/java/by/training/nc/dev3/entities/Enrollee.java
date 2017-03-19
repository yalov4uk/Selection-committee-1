/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.abstracts.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class Enrollee extends Human {

    private List<Point> points;

    public Enrollee() {
        super();
        points = new ArrayList<Point>();
    }

    public Enrollee(String name) {
        super(name);
        points = new ArrayList<Point>();
    }

    public Enrollee(String name, List<Point> points) {
        super(name);
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Enrollee{" + "id=" + id + ", name=" + name + ", points=" + points + '}';
    }
}
