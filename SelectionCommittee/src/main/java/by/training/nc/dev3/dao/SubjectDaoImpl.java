package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.SubjectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/10/2017.
 */
public class SubjectDaoImpl extends BaseDaoImpl<Subject> implements SubjectDao {
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
        return "delete from subjects";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Subject object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Subject object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(4, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject dao prepare for update error");
        }
    }

    @Override
    protected List<Subject> parseResultSet(ResultSet rs) {
        List<Subject> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Subject(rs.getInt("id"), rs.getInt("value"),
                        rs.getInt("subjectNameId"), rs.getInt("userId")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject dao parse result set error");
        }
        return result;
    }

    public SubjectDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Subject object) {
        try {
            statement.setInt(1, object.getValue());
            statement.setInt(2, object.getSubjectNameId());
            statement.setInt(3, object.getUserId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject dao prepare statement error");
        }
    }

    public List<Subject> findAllByUserId(int userId) {
        List<Subject> list;
        String sql = getSelectQuery() + " where userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject dao find all by user id error");
        }
        return list;
    }
}
