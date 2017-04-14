package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
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
        return "delete from users";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(5, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("User dao prepare for update error");
        }
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        List<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new User(rs.getInt("id"), rs.getString("name"),
                        rs.getString("login"), rs.getString("password"),
                        rs.getInt("roleId")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("User dao parse result set error");
        }
        return result;
    }

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, User object) {
        try {
            statement.setString(1, object.getName());
            statement.setString(2, object.getLogin());
            statement.setString(3, object.getPassword());
            statement.setInt(4, object.getRoleId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("User dao prepare statement error");
        }
    }

    public User findByLogin(String login) {
        List<User> list;
        String sql = "select * from users where login = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("User dao find by login error");
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }
}
