package by.training.nc.dev3;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 *
 */
public class Main {

    private static final String URL_FIXED = "jdbc:mysql://localhost:3306/selection_committee?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        //IServer server = new Server();
        //server.main();


        try (Connection connection = DriverManager.getConnection(URL_FIXED, USERNAME, PASSWORD)) {
            if (!connection.isClosed()) {
                System.out.println("Connected");
            }

            /*UserDao ud = new UserDao(connection);
            User user = ud.persist(new User("valera", "v1", "v1pas", 1));
            System.out.println(ud.find(user.getId()));*/

            /*FacultyDao fd = new FacultyDao(connection);
            Faculty faculty = fd.persist(new Faculty("FKSIS111", 14));
            System.out.println(fd.find(faculty.getId()));*/

            /*StatementDao sd = new StatementDao(connection);
            Statement statement = sd.persist(new Statement(1, 1));
            System.out.println(sd.find(statement.getId()));*/

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
