package by.training.nc.dev3;

import by.training.nc.dev3.iterfaces.IServer;
import by.training.nc.dev3.server.Server;

/**
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        IServer server = new Server();
        server.main();
    }
}
