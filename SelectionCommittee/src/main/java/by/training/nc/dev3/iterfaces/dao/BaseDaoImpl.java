package by.training.nc.dev3.iterfaces.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public interface BaseDaoImpl<T> {
    T persist(T object) throws SQLException;

    T find(int key) throws SQLException;

    void update(T object) throws SQLException;

    void delete(int key) throws SQLException;

    List<T> getAll() throws SQLException;
}
