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
            //User user1 = ud.persist(new User("valera", "v1", "v1pas", 1));
            User user = ud.find(1);
            System.out.println(ud.find(user.getId()));
            user.setName("Temp1");
            user.setLogin("кирилица");
            ud.update(user);
            System.out.println(ud.find(user.getId()));
            //ud.delete(2);
            for (User user2: ud.getAll()) {
                System.out.println(user2);
            }*/

            /*FacultyDao fd = new FacultyDao(connection);
            Faculty faculty = fd.persist(new Faculty("FKSIS111", 14));
            System.out.println(fd.find(faculty.getId()));*/

            /*StatementDao sd = new StatementDao(connection);
            Statement statement = sd.persist(new Statement(1, 1));
            System.out.println(sd.find(statement.getId()));*/

            /*RoleDao rd = new RoleDao(connection);
            Role role = rd.persist(new Role("tempRole"));
            System.out.println(rd.find(role.getId()));*/

            /*SubjectNameDao snd = new SubjectNameDao(connection);
            SubjectName subjectName = snd.persist(new SubjectName("tempSubjNameкиоилица"));
            System.out.println(snd.find(subjectName.getId()));*/

            /*SubjectDao sd = new SubjectDao(connection);
            Subject subject = sd.persist(new Subject(92, 1, 3));
            System.out.println(sd.find(subject.getId()));*/

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
