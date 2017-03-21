/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tasks;

import by.training.nc.dev3.entities.Statement;
import java.util.Comparator;

/**
 *
 * @author Valera Yalov4uk
 */
public class StatementComparator implements Comparator<Statement> {

    public int compare(Statement o1, Statement o2) {
       return o1.getEnrollee().compareTo(o2.getEnrollee());
    }
    
}
