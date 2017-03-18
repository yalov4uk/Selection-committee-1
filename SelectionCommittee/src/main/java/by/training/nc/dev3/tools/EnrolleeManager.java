/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;

/**
 *
 * @author Valera Yalov4uk
 */
public class EnrolleeManager {

    private Enrollee enrollee;
    
    public Statement Register(Faculty faculty){
        return new Statement(enrollee, faculty, false);
    }

    public EnrolleeManager() {
    }

    public EnrolleeManager(Enrollee enrollee) {
        this.enrollee = enrollee;
    }

    public Enrollee getEnrollee() {
        return enrollee;
    }

    public void setEnrollee(Enrollee enrollee) {
        this.enrollee = enrollee;
    }
}
