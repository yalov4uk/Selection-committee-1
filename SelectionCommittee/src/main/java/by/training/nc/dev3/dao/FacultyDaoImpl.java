package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.FacultyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class FacultyDaoImpl extends BaseDaoImpl<Faculty> implements FacultyDao {
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
        return "delete from faculties";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Faculty object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Faculty object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(3, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Faculty dao prepare for update error");
        }
    }

    @Override
    protected List<Faculty> parseResultSet(ResultSet rs) {
        List<Faculty> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Faculty(rs.getInt("id"), rs.getInt("maxSize"),
                        rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Faculty dao parse result set error");
        }
        return result;
    }

    public FacultyDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Faculty object) {
        try {
            statement.setInt(1, object.getMaxSize());
            statement.setString(2, object.getName());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Faculty dao prepare for update error");
        }
    }

    public Faculty findByName(String name) {
        List<Faculty> list;
        String sql = "select * from faculties where name = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Faculty find by name error");
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }
}
