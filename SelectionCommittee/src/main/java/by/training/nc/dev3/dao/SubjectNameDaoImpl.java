package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.SubjectName;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.SubjectNameDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/10/2017.
 */
public class SubjectNameDaoImpl extends BaseDaoImpl<SubjectName> implements SubjectNameDao {
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
        return "delete from subject_names";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, SubjectName object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, SubjectName object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject name dao prepare for update error");
        }
    }

    @Override
    protected List<SubjectName> parseResultSet(ResultSet rs) {
        List<SubjectName> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new SubjectName(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject name dao parse result set error");
        }
        return result;
    }

    public SubjectNameDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, SubjectName object) {
        try {
            statement.setString(1, object.getName());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Subject name dao prepare statement error");
        }
    }
}
