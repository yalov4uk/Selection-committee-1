package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.RequiredSubject;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.RequiredSubjectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/12/2017.
 */
public class RequiredSubjectDaoImpl extends BaseDaoImpl<RequiredSubject> implements RequiredSubjectDao {
    @Override
    public String getCreateQuery() {
        return "insert into required_subjects (facultyId, subjectNameId) values (?, ?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from required_subjects";
    }

    @Override
    protected String getUpdateQuery() {
        return "update required_subjects set facultyId = ?, subjectNameId - ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from required_subjects";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, RequiredSubject object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, RequiredSubject object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(3, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Required subjects dao prepare for update error");
        }
    }

    @Override
    protected List<RequiredSubject> parseResultSet(ResultSet rs) {
        List<RequiredSubject> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new RequiredSubject(rs.getInt("id"), rs.getInt("facultyId"),
                        rs.getInt("subjectNameId")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Required subjects dao parse result set error");
        }
        return result;
    }

    public RequiredSubjectDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, RequiredSubject object) {
        try {
            statement.setInt(1, object.getFacultyId());
            statement.setInt(2, object.getSubjectNameId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Required subjects dao prepare statement error");
        }
    }

    public List<RequiredSubject> findAllByFacultyId(int facultyId) {
        List<RequiredSubject> list;
        String sql = getSelectQuery() + " where facultyId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facultyId);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Required subjects dao find all by faculty id error");
        }
        return list;
    }
}
