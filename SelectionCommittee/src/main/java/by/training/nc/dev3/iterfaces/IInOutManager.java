package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Statement;

import java.util.List;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IInOutManager {

    int inputInteger(java.lang.String message, int min, int max);

    java.lang.String inputString(java.lang.String message);

    void outputResultEntrants(Map<String, List<Statement>> statements);

    <T> void outputList(List<T> list, java.lang.String message);

    void outputString(java.lang.String message);
}
