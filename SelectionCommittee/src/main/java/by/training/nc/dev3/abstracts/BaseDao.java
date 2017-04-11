package by.training.nc.dev3.abstracts;

import by.training.nc.dev3.iterfaces.BaseDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public abstract class BaseDao<T> implements BaseDaoImpl<T> {
    private Connection connection;

    public abstract String getCreateQuery();

    protected abstract String getSelectQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DaoException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DaoException;

    protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;

    public T persist(T object) throws DaoException {
        List<T> list;
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On create modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        sql = getSelectQuery() + " where id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        if ((list == null) || (list.size() != 1)) {
            throw new DaoException("Exception on findByPK new persist data.");
        }
        return list.iterator().next();
    }

    public void update(T object) throws DaoException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public T find(int key) throws DaoException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new DaoException("Received more than one record.");
        }
        return list.iterator().next();

    }

    public void delete(int key) throws DaoException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<T> getAll() throws DaoException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }

    public BaseDao(Connection connection) {
        this.connection = connection;
    }
}
