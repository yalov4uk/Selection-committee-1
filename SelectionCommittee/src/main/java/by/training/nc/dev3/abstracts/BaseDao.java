package by.training.nc.dev3.abstracts;

import by.training.nc.dev3.iterfaces.dao.BaseDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public abstract class BaseDao<T> implements BaseDaoImpl<T> {
    protected Connection connection;

    protected abstract String getCreateQuery();

    protected abstract String getSelectQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws SQLException;

    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;

    public T persist(T object) throws SQLException {
        List<T> list;
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            statement.executeUpdate();
        }
        sql = getSelectQuery() + " where id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        return list.iterator().next();
    }

    public void update(T object) throws SQLException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object);
            statement.executeUpdate();
        }
    }

    public T find(int key) throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }

    public void delete(int key) throws SQLException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            statement.executeUpdate();
            statement.close();
        }
    }

    public List<T> getAll() throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        return list;
    }

    public BaseDao(Connection connection) {
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
