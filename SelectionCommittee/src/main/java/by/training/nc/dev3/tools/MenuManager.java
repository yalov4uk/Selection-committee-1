/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Enrollee;
import by.training.nc.dev3.enums.PointName;
import by.training.nc.dev3.exceptions.InvalidInput;
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
}
