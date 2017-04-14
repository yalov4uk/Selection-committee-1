package by.training.nc.dev3.iterfaces.dao;

import by.training.nc.dev3.entities.RequiredSubject;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/12/2017.
 */
public interface RequiredSubjectDao extends BaseDao<RequiredSubject> {

    List<RequiredSubject> findAllByFacultyId(int facultyId);
}
