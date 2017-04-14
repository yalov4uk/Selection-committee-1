package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.StatementDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class StatementDaoImpl extends BaseDaoImpl<Statement> implements StatementDao {
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
        return "delete from statements";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Statement object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Statement object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(4, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Statement dao prepare for update error");
        }
    }

    @Override
    protected List<Statement> parseResultSet(ResultSet rs) {
        List<Statement> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Statement(rs.getInt("id"), rs.getInt("userId"),
                        rs.getInt("facultyId"), rs.getDate("date")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Statement dao parse result set error");
        }
        return result;
    }

    public StatementDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Statement object) {
        try {
            statement.setDate(1, object.getDate());
            statement.setInt(2, object.getUserId());
            statement.setInt(3, object.getFacultyId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Statement dao prepare statement error");
        }
    }
}
