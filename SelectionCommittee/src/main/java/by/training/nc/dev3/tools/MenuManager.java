/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.enums.FacultyName;
import by.training.nc.dev3.enums.PointName;
import by.training.nc.dev3.exceptions.InvalidInput;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Valera Yalov4uk
 */
public class MenuManager {

    private static Scanner in = new Scanner(System.in);

    public static Integer enterPointValue(Enrollee enrollee,
            PointName requiredPointName) {
        while (true) {
            System.out.println(enrollee.getName() + " enter your points on the "
                    + requiredPointName);
            try {
                Integer value = in.nextInt();
                if (value > 100 || value < 0) {
                    throw new InvalidInput("Points must be in range 0..100",
                            value.toString());
                } else {
                    return value;
                }
            } catch (InvalidInput ii) {
                System.out.println(ii.getMessage() + ". You entered: "
                        + ii.getErrorString());
            }
        }
    }

    public static void writeResultEntrants(Map<FacultyName, List<Statement>> statements) {
        for (List<Statement> list : statements.values()) {
            if (!list.isEmpty()) {
                System.out.println("Faculty "
                        + list.get(0).getFaculty().getName() + ":");
                for (int j = 0; j < list.size(); j++) {
                    String response = j < list.get(0).getFaculty().getMaxSize()
                            ? " accepted" : " rejected";
                    System.out.println("    " + list.get(j).getEnrollee() + response);

                }
            }
        }
    }
}
