package by.training.nc.dev3.iterfaces.factories.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera Yalov4uk on 4/16/2017.
 */
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
