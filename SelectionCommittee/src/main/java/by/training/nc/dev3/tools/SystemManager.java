/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.iterfaces.Calculatable;
import by.training.nc.dev3.tasks.StatementComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Valera Yalov4uk
 */
public class SystemManager implements Calculatable {

    @Override
    public Map<FacultyName, List<Statement>> calculate(
            List<Statement> statements) {
        Map<FacultyName, List<Statement>> simpleMap = initilizeMap();
        statements.forEach((statement) -> {
            simpleMap.get(statement.getFaculty().getName()).add(statement);
        });
        return sortMap(simpleMap);
    }

    private Map<FacultyName, List<Statement>> initilizeMap() {
        Map<FacultyName, List<Statement>> simpleMap = new HashMap<>();
        for (FacultyName facultyName : FacultyName.values()) {
            simpleMap.put(facultyName, new ArrayList<>());
        }
        return simpleMap;
    }

    private Map<FacultyName, List<Statement>> sortMap(Map<FacultyName, List<Statement>> simpleMap) {
        simpleMap.values().forEach((list) -> {
            //Collections.sort(list);  //comparable
            list.sort(new StatementComparator());  //comparator
        });
        return simpleMap;
    }
}
