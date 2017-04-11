package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/10/2017.
 */
public class SubjectDao extends BaseDao<Subject> {
    @Override
    public String getCreateQuery() {
        return "insert into subjects (value, subjectNameId, userId) values (?, ?, ?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from subjects";
    }

    @Override
    protected String getUpdateQuery() {
        return "update subjects set value = ?, subjectNameId = ?, userId = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from subjects where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Subject object) throws DaoException {
        try {
            prepareStatement(statement, object);
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Subject object) throws DaoException {
        try {
            prepareStatement(statement, object);
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected List<Subject> parseResultSet(ResultSet rs) throws DaoException {
        List<Subject> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Subject(rs.getInt("id"), rs.getInt("value"),
                        rs.getInt("subjectNameId"), rs.getInt("userId")));
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    public SubjectDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Subject object) throws SQLException {
        statement.setInt(1, object.getValue());
        statement.setInt(2, object.getSubjectNameId());
        statement.setInt(3, object.getUserId());
    }
}
