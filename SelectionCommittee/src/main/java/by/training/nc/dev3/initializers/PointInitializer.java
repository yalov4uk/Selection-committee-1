/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.initializers;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.entities.Certificate;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.enums.PointName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class PointInitializer {

    public static List<Point> initialize() {
        List<Point> list = new ArrayList<>();
        list.add(new Certificate());
        list.add(new Subject(PointName.CHEMISTRY));
        list.add(new Subject(PointName.HISTORY));
        list.add(new Subject(PointName.LANGUAGE));
        list.add(new Subject(PointName.MATHEMATICS));
        list.add(new Subject(PointName.PHYSICS));
        return list;
    }
}
