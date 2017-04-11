package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.SubjectName;
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
public class SubjectNameDao extends BaseDao<SubjectName> {
    @Override
    public String getCreateQuery() {
        return "insert into subject_names (name) values (?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from subject_names";
    }

    @Override
    protected String getUpdateQuery() {
        return "update subject_names set name = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from subject_names where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, SubjectName object) throws DaoException {
        try {
            prepareStatement(statement, object);
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, SubjectName object) throws DaoException {
        try {
            prepareStatement(statement, object);
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);

        }
    }

    @Override
    protected List<SubjectName> parseResultSet(ResultSet rs) throws DaoException {
        List<SubjectName> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new SubjectName(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    public SubjectNameDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, SubjectName object) throws SQLException {
        statement.setString(1, object.getName());
    }
}
