/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.initializers;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.entities.Certificate;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.PointName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valera Yalov4uk
 */
public class PointInitializer {

    public static List<Point> initialize() {
        List<Point> list = new ArrayList();
        list.add(new Certificate());
        list.add(new Subject(PointName.chemistry));
        list.add(new Subject(PointName.history));
        list.add(new Subject(PointName.language));
        list.add(new Subject(PointName.mathematics));
        list.add(new Subject(PointName.physics));
        return list;
    }
}
