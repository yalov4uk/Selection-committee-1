package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.RegisteredUser;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public class RegisteredUserDaoImpl extends BaseDaoImpl<RegisteredUser> implements RegisteredUserDao {
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
        return "delete from registered_users";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, RegisteredUser object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, RegisteredUser object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(3, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Registered users dao prepare for update error");
        }
    }

    @Override
    protected List<RegisteredUser> parseResultSet(ResultSet rs) {
        List<RegisteredUser> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new RegisteredUser(rs.getInt("id"), rs.getInt("facultyId"),
                        rs.getInt("userId")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Registered users dao parse result set error");
        }
        return result;
    }

    public RegisteredUserDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, RegisteredUser object) {
        try {
            statement.setInt(1, object.getUserId());
            statement.setInt(2, object.getFacultyId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Registered users dao prepare statement error");
        }
    }

    public RegisteredUser findRegisteredUserByIds(int userId, int facultyId){
        List<RegisteredUser> list;
        String sql = "select * from registered_users where userId = ? and facultyId = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, facultyId);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Registered users dao find by ids error");
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }

    public void deleteByUserId(int userId){
        String sql = getDeleteQuery() + " where userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoUncheckedException("Delete error");
        }
    }

    public List<RegisteredUser> findRegisteredUserByFacultyId(int facultyId){
        List<RegisteredUser> list;
        String sql = "select * from registered_users where facultyId = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facultyId);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Registered users dao find by faculty id error");
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }
}
