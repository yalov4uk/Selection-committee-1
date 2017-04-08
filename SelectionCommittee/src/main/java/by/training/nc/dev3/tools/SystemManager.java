/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.comparators.StatementComparatorByAverageScore;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.iterfaces.ISystemManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Valera Yalov4uk
 */
public class SystemManager implements ISystemManager {

    public Map<String, List<Statement>> calculate(List<Statement> statements) {
        Map<String, List<Statement>> simpleMap = new HashMap<>();
        statements.forEach((statement) -> {
            String facultyName = statement.getFaculty().getName();
            if (!simpleMap.containsKey(facultyName)) {
                simpleMap.put(facultyName, new ArrayList<>());
            }
            simpleMap.get(facultyName).add(statement);
        });
        return sortMap(simpleMap);
    }

    private Map<String, List<Statement>> sortMap(Map<String, List<Statement>> simpleMap) {
        simpleMap.values().forEach((list) -> {
            //Collections.sort(list);  //comparable
            list.sort(new StatementComparatorByAverageScore());  //comparator
        });
        return simpleMap;
    }
}
