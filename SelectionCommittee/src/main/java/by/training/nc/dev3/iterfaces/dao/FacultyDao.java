package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.Faculty;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface FacultyDao extends BaseDao<Faculty> {

    Faculty findByName(String name);
}
