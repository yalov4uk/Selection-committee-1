/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Human;
import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.iterfaces.IServerSubMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class Enrollee extends Human {

    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private List<Point> points;

    public void goNextMenu(IServerSubMenu server) {
        server.menuEnrollee();
    }

    public Integer getAverageScore(Faculty faculty){
        int result = 0;
        for (Point point : points) {
            if (faculty.getRequiredPoints().contains(point.getName())) {
                result += point.getValue();
            }
        }
        return result;
    }

    public Enrollee() {
        super();
        points = new ArrayList<>();
        count++;
    }

    public Enrollee(String name) {
        super(name);
        points = new ArrayList<>();
        count++;
    }

    public Enrollee(String name, List<Point> points) {
        super(name);
        this.points = points;
        count++;
    }

    public Enrollee(String name, String login, String password) {
        super(name, login, password);
        points = new ArrayList<>();
        count++;
    }

    public static int getCount() {
        return count;
    }

    /**
     * @return points
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * @param points
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    @Override
    public String toString() {
        return "Enrollee{" + super.toString() + ", points=" + points + ", count=" + count + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Enrollee enrollee = (Enrollee) o;

        return points != null ? points.equals(enrollee.points) : enrollee.points == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }
}
