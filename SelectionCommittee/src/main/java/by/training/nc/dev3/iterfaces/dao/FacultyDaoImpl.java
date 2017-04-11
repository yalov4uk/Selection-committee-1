package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.Faculty;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface FacultyDaoImpl extends BaseDaoImpl<Faculty> {
    Faculty findByName(String name) throws SQLException;
}
