package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.enums.FacultyName;

import java.util.List;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IInOutManager {

    int inputInteger(String message, int min, int max);

    String inputString(String message);

    void outputResultEntrants(Map<FacultyName, List<Statement>> statements);

    <T> void outputList(List<T> list, String message);

    void outputString(String message);
}
