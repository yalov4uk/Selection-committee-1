package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IEnrolleeManager {

    void registerEnrollee(Faculty faculty, IInOutManager inOutManager);

    void setEnrollee(Enrollee enrollee);
}
