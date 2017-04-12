package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.RequiredSubject;
import by.training.nc.dev3.iterfaces.dao.RequiredSubjectsDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/12/2017.
 */
public class RequiredSubjectsDao extends BaseDao<RequiredSubject> implements RequiredSubjectsDaoImpl {
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
        return "delete from required_subjects where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, RequiredSubject object) throws SQLException {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, RequiredSubject object) throws SQLException {
        prepareStatement(statement, object);
        statement.setInt(3, object.getId());
    }

    @Override
    protected List<RequiredSubject> parseResultSet(ResultSet rs) throws SQLException {
        List<RequiredSubject> result = new LinkedList<>();
        while (rs.next()) {
            result.add(new RequiredSubject(rs.getInt("id"), rs.getInt("facultyId"),
                    rs.getInt("subjectNameId")));
        }
        return result;
    }

    public RequiredSubjectsDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, RequiredSubject object) throws SQLException {
        statement.setInt(1, object.getFacultyId());
        statement.setInt(2, object.getSubjectNameId());
    }

    public List<RequiredSubject> findAllByFacultyId(int facultyId) throws SQLException {
        List<RequiredSubject> list;
        String sql = getSelectQuery() + " where facultyId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facultyId);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        return list;
    }
}
