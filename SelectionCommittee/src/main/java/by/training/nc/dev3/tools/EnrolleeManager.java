/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.abstracts.Point;
import by.training.nc.dev3.entities.Certificate;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.enums.PointName;

/**
 *
 * @author Valera Yalov4uk
 */
public class EnrolleeManager {

    private Enrollee enrollee;

    public void register(Faculty faculty) {
        int maxPoints = 100;
        int minPoints = 0;
        for (PointName requiredPointName : faculty.getRequiredPoints()) {
            String message = enrollee.getName() + " enter your points on the " + 
                    requiredPointName;
            Integer value = new MenuManager().enterValue(message, 
                    minPoints, maxPoints);
            Point point = requiredPointName.equals(PointName.certificate)
                    ? new Certificate()
                    : new Subject(requiredPointName);
            point.setValue(value);
            enrollee.addPoint(point);
        }
        faculty.setRegisteredEntrant(enrollee);
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
