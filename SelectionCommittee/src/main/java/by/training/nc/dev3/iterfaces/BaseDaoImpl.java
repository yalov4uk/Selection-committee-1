package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.exceptions.DaoException;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public interface BaseDaoImpl<T> {
    T persist(T object) throws DaoException;

    T find(int key) throws DaoException;

    void update(T object) throws DaoException;

    void delete(int key) throws DaoException;

    List<T> getAll() throws DaoException;
}
