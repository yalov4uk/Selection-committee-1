package by.training.nc.dev3;

import by.training.nc.dev3.iterfaces.IServer;
import by.training.nc.dev3.server.Server;

import java.sql.SQLException;

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
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }



        /*BoneCPConfig config = new BoneCPConfig();
        config.setJdbcUrl(URL_FIXED);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setMinConnectionsPerPartition(5);
        config.setMaxConnectionsPerPartition(20);
        config.setPartitionCount(1);
        try (BoneCP connectionPool = new BoneCP(config)) {
            Connection connection = connectionPool.getConnection();
            UserDao ud = new UserDao(connection);
            System.out.println(ud.findByLogin("кирилица"));
        }

        try (BoneCP db = new BoneCP(BoneCPConf.initialize())){
            Connection connection = db.getConnection();
            UserDao ud = new UserDao(connection);
            System.out.println(ud.findByLogin("кирилица"));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }


        try (Connection connection = DriverManager.getConnection(URL_FIXED, USERNAME, PASSWORD)) {
            if (!connection.isClosed()) {
                System.out.println("Connected");
            }

            UserDao ud = new UserDao(connection);
            User user1 = ud.persist(new User("valera", "v1", "v1pas", 1));
            User user = ud.find(1);
            System.out.println(ud.find(user.getId()));
            user.setName("Temp1");
            user.setLogin("кирилица");
            ud.update(user);
            System.out.println(ud.find(user.getId()));
            ud.delete(2);
            for (User user2: ud.getAll()) {
                System.out.println(user2);
            }
            System.out.println(ud.findByLogin("кирилица"));

            FacultyDao fd = new FacultyDao(connection);
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

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
