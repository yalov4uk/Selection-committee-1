package by.training.nc.dev3.dao;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class FacultyDao extends BaseDao<Faculty> {
    @Override
    public String getCreateQuery() {
        return "insert into faculties (maxSize, name) values (?, ?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from faculties";
    }

    @Override
    protected String getUpdateQuery() {
        return "update faculties set maxSize = ?, name = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from faculties where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Faculty object) throws DaoException {
        try {
            prepareStatement(statement, object);
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Faculty object) throws DaoException {
        try {
            prepareStatement(statement, object);
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected List<Faculty> parseResultSet(ResultSet rs) throws DaoException {
        List<Faculty> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Faculty(rs.getInt("id"), rs.getInt("maxSize"),
                        rs.getString("name")));
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    public FacultyDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Faculty object) throws SQLException {
        statement.setInt(1, object.getMaxSize());
        statement.setString(2, object.getName());
    }
}
