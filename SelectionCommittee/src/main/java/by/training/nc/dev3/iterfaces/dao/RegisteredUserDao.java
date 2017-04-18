package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.RegisteredUser;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public interface RegisteredUserDao extends BaseDao<RegisteredUser> {

    RegisteredUser findRegisteredUserByIds(int userId, int facultyId);

    void deleteByUserId(int userId);

    List<RegisteredUser> findRegisteredUserByFacultyId(int facultyId);
}
