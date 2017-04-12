/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.tools;

import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.exceptions.InvalidInput;
import by.training.nc.dev3.iterfaces.IInOutManager;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Valera Yalov4uk
 */
public class InOutManager implements IInOutManager {

    private final Scanner in;

    public int inputInteger(String message, int min, int max) {
        while (true) {
            System.out.println(message);
            try {
                Integer value = Integer.parseInt(getIn().nextLine());
                if (value < min || value > max) {
                    throw new InvalidInput("Value must be in range " + min + ".." + max, value.toString());
                } else {
                    return value;
                }
            } catch (InvalidInput ii) {
                System.out.println(ii.getMessage() + ". You entered: " + ii.getErrorString());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
    }

    public String inputString(String message) {
        System.out.println(message);
        return getIn().nextLine();
    }

    public void outputResultEntrants(Map<String, List<Statement>> statements) {
        for (List<Statement> list : statements.values()) {
            if (!list.isEmpty()) {
                System.out.println("Faculty " + list.get(0).getFaculty().getName() + ":");
                for (int j = 0; j < list.size(); j++) {
                    String response = j < list.get(0).getFaculty().getMaxSize() ? " accepted" : " rejected";
                    System.out.println("    " + list.get(j).getUser() + response);
                }
            }
        }
    }

    public <T> void outputList(List<T> list, String message) {
        System.out.println(message);
        list.forEach((elem) -> {
            System.out.println("    " + elem);
        });
    }

    public void outputString(String message) {
        System.out.println(message);
    }

    public InOutManager() {
        in = new Scanner(System.in);
    }

    public Scanner getIn() {
        return in;
    }
}
