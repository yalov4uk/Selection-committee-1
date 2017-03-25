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
import by.training.nc.dev3.iterfaces.IEnrolleeManager;
import by.training.nc.dev3.iterfaces.IInOutManager;

/**
 * @author Valera Yalov4uk
 */
public class EnrolleeManager implements IEnrolleeManager {

    private Enrollee enrollee;

    public void registerEnrollee(Faculty faculty, IInOutManager inOutManager) {
        for (PointName requiredPointName : faculty.getRequiredPoints()) {
            String message = enrollee.getName() + " enter your points on the " + requiredPointName;
            Point point = requiredPointName.equals(PointName.CERTIFICATE) ? new Certificate()
                    : new Subject(requiredPointName);
            point.setValue(inOutManager.inputInteger(message, 0, 100));
            enrollee.addPoint(point);
        }
        faculty.getRegisteredEntrants().add(enrollee);
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
