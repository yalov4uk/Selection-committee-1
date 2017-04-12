package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.RegisteredUser;
import by.training.nc.dev3.iterfaces.dao.RegisteredUsersDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public class RegisteredUsersDao extends BaseDao<RegisteredUser> implements RegisteredUsersDaoImpl {
    @Override
    public String getCreateQuery() {
        return "insert into registered_users (userId, facultyId) values (?, ?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from registered_users";
    }

    @Override
    protected String getUpdateQuery() {
        return "update registered_users set userId = ?, facultyId = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from registered_users where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, RegisteredUser object) throws SQLException {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, RegisteredUser object) throws SQLException {
        prepareStatement(statement, object);
        statement.setInt(3, object.getId());
    }

    @Override
    protected List<RegisteredUser> parseResultSet(ResultSet rs) throws SQLException {
        List<RegisteredUser> result = new LinkedList<>();
        while (rs.next()) {
            result.add(new RegisteredUser(rs.getInt("id"), rs.getInt("facultyId"),
                    rs.getInt("userId")));
        }
        return result;
    }

    public RegisteredUsersDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, RegisteredUser object) throws SQLException {
        statement.setInt(1, object.getUserId());
        statement.setInt(2, object.getFacultyId());
    }

    public RegisteredUser findRegisteredUserByIds(int userId, int facultyId) throws SQLException{
        List<RegisteredUser> list;
        String sql = "select * from registered_users where userId = ? and facultyId = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, facultyId);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }
}
