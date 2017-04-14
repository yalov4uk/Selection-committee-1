package by.training.nc.dev3.abstracts;

import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    protected Connection connection;

    protected abstract String getCreateQuery();

    protected abstract String getSelectQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    protected abstract List<T> parseResultSet(ResultSet rs);

    public T persist(T object) {
        List<T> list;
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoUncheckedException("Persist error");
        }
        sql = getSelectQuery() + " where id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Persist error in select");
        }
        return list.iterator().next();
    }

    public void update(T object) {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoUncheckedException("Update error");
        }
    }

    public T find(int key) {
        List<T> list;
        String sql = getSelectQuery();
        sql += " where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Find error");
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }

    public void delete(int key) {
        String sql = getDeleteQuery() + " where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoUncheckedException("Delete error");
        }
    }

    public List<T> getAll() {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new DaoUncheckedException("Select all error");
        }
        return list;
    }

    public BaseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e){
            throw new DaoUncheckedException("Connection close error");
        }
    }
}
