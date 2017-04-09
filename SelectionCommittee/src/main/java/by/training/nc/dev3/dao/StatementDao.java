package by.training.nc.dev3.dao;

import by.training.nc.dev3.entities.Statement;
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
public class StatementDao extends BaseDao<Statement> {
    @Override
    public String getCreateQuery() {
        return "insert into statements (date, userId, facultyId) values (?, ?, ?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from statements";
    }

    @Override
    protected String getUpdateQuery() {
        return "update statements set date = ?, userId = ?, facultyId = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from statements where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Statement object) throws DaoException {
        try {
            prepareStatement(statement, object);
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Statement object) throws DaoException {
        try {
            prepareStatement(statement, object);
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected List<Statement> parseResultSet(ResultSet rs) throws DaoException {
        List<Statement> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Statement(rs.getInt("id"), rs.getInt("facultyId"),
                        rs.getInt("userId"), rs.getDate("date")));
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    public StatementDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Statement object) throws SQLException {
        statement.setDate(1, object.getDate());
        statement.setInt(2, object.getUserId());
        statement.setInt(3, object.getFacultyId());
    }
}
