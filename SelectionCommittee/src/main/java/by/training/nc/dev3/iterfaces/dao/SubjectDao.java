package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.Subject;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface SubjectDao extends BaseDao<Subject> {

    List<Subject> findAllByUserId(int userId);
}
