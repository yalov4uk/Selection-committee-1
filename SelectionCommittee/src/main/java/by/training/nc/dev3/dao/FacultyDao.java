package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.iterfaces.dao.FacultyDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class FacultyDao extends BaseDao<Faculty> implements FacultyDaoImpl{
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
    protected void prepareStatementForInsert(PreparedStatement statement, Faculty object) throws SQLException {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Faculty object) throws SQLException {
        prepareStatement(statement, object);
        statement.setInt(3, object.getId());
    }

    @Override
    protected List<Faculty> parseResultSet(ResultSet rs) throws SQLException {
        List<Faculty> result = new LinkedList<>();
        while (rs.next()) {
            result.add(new Faculty(rs.getInt("id"), rs.getInt("maxSize"),
                    rs.getString("name")));
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

    public Faculty findByName(String name) throws SQLException {
        List<Faculty> list;
        String sql = "select * from faculties where name = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }
}
