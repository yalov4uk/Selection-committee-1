package by.training.nc.dev3.controller;

import by.training.nc.dev3.factories.CommandFactoryImpl;
import by.training.nc.dev3.iterfaces.factories.CommandFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valera Yalov4uk on 4/15/2017.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactoryImpl.getInstance();
        Command command = commandFactory.getCommand(request.getParameter("command"));
        if (command != null) {
            String page = command.execute(request, response);
            if (page != null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        }
    }
}
