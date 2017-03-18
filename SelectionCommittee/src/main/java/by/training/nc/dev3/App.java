package by.training.nc.dev3;

import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import by.training.nc.dev3.tools.EnrolleeManager;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Enrollee enrollee1 = new Enrollee("temp1");
        Enrollee enrollee2 = new Enrollee("temp1");
        System.out.println(enrollee1);
        System.out.println(enrollee2);
        
        List<Subject> subjects = new ArrayList();
        subjects.add(Subject.mathematics);
        subjects.add(Subject.language);
        
        Faculty faculty1 = new Faculty(FacultyName.KSIS, 1, subjects);
        
        EnrolleeManager enrolleeManager = new EnrolleeManager(enrollee1);
        
        List<Statement> statements = new ArrayList();
        statements.add(enrolleeManager.Register(faculty1));
        for (Statement state : statements){
            System.out.println(state);
        }
        System.out.println("The end");
    }
}
