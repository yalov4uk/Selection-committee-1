/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.initializers;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.PointName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class FacultyInitializer {

    public static List<Faculty> initialize() {
        List<PointName> p1 = new ArrayList<>();
        p1.add(PointName.CERTIFICATE);

        List<PointName> p2 = new ArrayList<>();
        p2.add(PointName.CERTIFICATE);
        p2.add(PointName.CHEMISTRY);

        List<PointName> p3 = new ArrayList<>();
        p3.add(PointName.CERTIFICATE);
        p3.add(PointName.CHEMISTRY);
        p3.add(PointName.HISTORY);

        List<PointName> p4 = new ArrayList<>();
        p4.add(PointName.CERTIFICATE);
        p4.add(PointName.LANGUAGE);
        p4.add(PointName.MATHEMATICS);
        p4.add(PointName.PHYSICS);

        List<PointName> p5 = new ArrayList<>();
        p5.add(PointName.CERTIFICATE);
        p5.add(PointName.HISTORY);
        p5.add(PointName.LANGUAGE);
        p5.add(PointName.MATHEMATICS);
        p5.add(PointName.PHYSICS);

        List<Faculty> list = new ArrayList<>();
        list.add(new Faculty(FacultyName.FITU, 5, p1));
        list.add(new Faculty(FacultyName.FKP, 4, p2));
        list.add(new Faculty(FacultyName.FRE, 2, p3));
        list.add(new Faculty(FacultyName.IEF, 3, p4));
        list.add(new Faculty(FacultyName.KSIS, 2, p5));
        return list;
    }
}
