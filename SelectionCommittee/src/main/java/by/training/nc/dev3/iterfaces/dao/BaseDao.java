package by.training.nc.dev3.iterfaces.dao;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public interface BaseDao<T> {

    T persist(T object);

    T find(int key);

    void update(T object);

    void delete(int key);

    List<T> getAll();

    void close();
}
