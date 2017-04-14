/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.exceptions;

/**
 * @author Valera Yalov4uk
 */
public class InvalidInput extends Exception {

    private String errorString;

    /**
     * Creates a new instance of <code>NewException</code> without detail
     * message.
     */
    public InvalidInput() {
    }

    /**
     * Constructs an instance of <code>NewException</code> with the specified
     * detail message.
     *
     * @param msg         the detail message.
     * @param errorString
     */
    public InvalidInput(String msg, String errorString) {
        super(msg);
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
