package by.training.nc.dev3;

import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.IServer;
import by.training.nc.dev3.server.Server;

/**
 *
 *
 */
public class Main {

    private static final String URL_FIXED = "jdbc:mysql://localhost:3306/selection_committee?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            IServer server = new Server();
            server.main();
        } catch (DaoUncheckedException e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
    }
}
