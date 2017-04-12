package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.Subject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface SubjectDaoImpl extends BaseDaoImpl<Subject> {
    List<Subject> findAllByUserId(int userId) throws SQLException;
}
