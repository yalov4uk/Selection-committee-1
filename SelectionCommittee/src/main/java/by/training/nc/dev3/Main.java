package by.training.nc.dev3;

import by.training.nc.dev3.entities.Admin;
import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.ObjectCounter;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.PointName;
import by.training.nc.dev3.tools.AdminManager;
import java.util.ArrayList;
import java.util.List;
import by.training.nc.dev3.tools.EnrolleeManager;
import by.training.nc.dev3.tools.SystemManager;
import java.util.Map;

/**
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Enrollee enrollee1 = new Enrollee("temp1");
        Enrollee enrollee2 = new Enrollee("temp2");
        Enrollee enrollee3 = new Enrollee("temp3");
        Enrollee enrollee4 = new Enrollee("temp4");
        Enrollee enrollee5 = new Enrollee("temp5");

        List<PointName> requiredPoints1 = new ArrayList();
        requiredPoints1.add(PointName.mathematics);
        requiredPoints1.add(PointName.certificate);
        List<PointName> requiredPoints2 = new ArrayList();
        requiredPoints2.add(PointName.certificate);
        requiredPoints2.add(PointName.chemistry);
        requiredPoints2.add(PointName.language);

        Faculty faculty1 = new Faculty(FacultyName.KSIS, 1, requiredPoints1);
        Faculty faculty2 = new Faculty(FacultyName.FKP, 2, requiredPoints2);

        EnrolleeManager enrolleeManager = new EnrolleeManager(enrollee1);
        enrolleeManager.register(faculty1);

        enrolleeManager.setEnrollee(enrollee2);
        enrolleeManager.register(faculty1);

        enrolleeManager.setEnrollee(enrollee3);
        enrolleeManager.register(faculty2);

        enrolleeManager.setEnrollee(enrollee4);
        enrolleeManager.register(faculty2);

        enrolleeManager.setEnrollee(enrollee5);
        enrolleeManager.register(faculty2);

        Admin admin1 = new Admin();
        Admin admin2 = new Admin();

        AdminManager adminManager1 = new AdminManager(admin1);
        AdminManager adminManager2 = new AdminManager(admin2);

        List<Statement> statements = new ArrayList();
        statements.add(adminManager1.registerStatement(faculty1, "temp1"));
        statements.add(adminManager1.registerStatement(faculty1, "temp2"));
        statements.add(adminManager2.registerStatement(faculty2, "temp3"));
        statements.add(adminManager2.registerStatement(faculty2, "temp4"));
        statements.add(adminManager2.registerStatement(faculty2, "temp5"));

        SystemManager systemManager = new SystemManager();
        Map<FacultyName, List<Statement>> simpleMap = systemManager.
                calculate(statements);
        
        for (Map.Entry<FacultyName, List<Statement>> item : simpleMap.entrySet()) {

            System.out.println("Key: " + item.getKey() + " Value: " + item.getValue());
        }

        System.out.println("Object counter = " + ObjectCounter.getObjectCount());
    }
}
