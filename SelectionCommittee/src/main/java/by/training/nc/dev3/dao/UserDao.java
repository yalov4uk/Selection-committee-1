package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.iterfaces.dao.UserDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class UserDao extends BaseDao<User> implements UserDaoImpl {
    @Override
    public String getCreateQuery() {
        return "insert into users (name, login, password, roleId) values (?, ?, ?, ?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from users";
    }

    @Override
    protected String getUpdateQuery() {
        return "update users set name = ?, login = ?, password = ?, roleId = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from users where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws SQLException {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws SQLException {
        prepareStatement(statement, object);
        statement.setInt(5, object.getId());
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws SQLException {
        List<User> result = new LinkedList<>();
        while (rs.next()) {
            result.add(new User(rs.getInt("id"), rs.getString("name"),
                    rs.getString("login"), rs.getString("password"),
                    rs.getInt("roleId")));
        }
        return result;
    }

    public UserDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, User object) throws SQLException {
        statement.setString(1, object.getName());
        statement.setString(2, object.getLogin());
        statement.setString(3, object.getPassword());
        statement.setInt(4, object.getRoleId());
    }

    public User findByLogin(String login) throws SQLException {
        List<User> list;
        String sql = "select * from users where login = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }
}
