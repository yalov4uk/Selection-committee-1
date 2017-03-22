/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.enums.FacultyName;

import java.util.List;
import java.util.Map;

/**
 * @author Valera Yalov4uk
 */
public interface Calculatable {

    Map<FacultyName, List<Statement>> calculate(List<Statement> statements);
}
