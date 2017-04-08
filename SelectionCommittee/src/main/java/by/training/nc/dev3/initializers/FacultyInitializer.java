/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.initializers;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.SubjectName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valera Yalov4uk
 */
public class FacultyInitializer {

    public static List<Faculty> initialize(List<SubjectName> subjectNames) {
        List<Faculty> list = new ArrayList<>();
        List<SubjectName> l1 = new ArrayList<>(subjectNames.subList(0, 1));
        List<SubjectName> l2 = new ArrayList<>(subjectNames.subList(2, 4));
        List<SubjectName> l3 = new ArrayList<>(subjectNames.subList(1, 4));
        List<SubjectName> l4 = new ArrayList<>(subjectNames.subList(4, 5));
        List<SubjectName> l5 = new ArrayList<>(subjectNames.subList(3, 5));
        list.add(new Faculty("FITU", 5, l1));
        list.add(new Faculty("FKP", 4, l2));
        list.add(new Faculty("FRE", 2, l3));
        list.add(new Faculty("IEF", 3, l4));
        list.add(new Faculty("KSIS", 2, l5));
        return list;
    }
}
