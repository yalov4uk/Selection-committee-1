/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.abstracts.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class Enrollee extends Human implements Comparable {

    private List<Point> points;
    
    private static int count = 0;

    public Enrollee() {
        super();
        points = new ArrayList<Point>();
        count++;
    }

    public Enrollee(String name) {
        super(name);
        points = new ArrayList<Point>();
        count++;
    }

    public Enrollee(String name, List<Point> points) {
        super(name);
        this.points = points;
        count++;
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
        return "Enrollee{" + super.toString() + ", points=" + points + ", count=" + count + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.points != null ? this.points.hashCode() : 0);
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
        final Enrollee other = (Enrollee) obj;
        if (this.points != other.points && (this.points == null || !this.points.equals(other.points))) {
            return false;
        }
        if (!((Human) this).equals((Human) obj)) {
            return false;
        }
        return true;
    }

    public int compareTo(Object o) {
        int result = 0;
        for (Point point : this.getPoints()) {
            result -= point.getValue();
        }
        for (Point point : ((Enrollee) o).getPoints()) {
            result += point.getValue();
        }
        return result;
    }

    public static int getCount() {
        return count;
    }
}
