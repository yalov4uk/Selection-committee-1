package by.training.nc.dev3.initializers;

import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.factories.creators.*;
import by.training.nc.dev3.iterfaces.factories.creators.DaoCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/14/2017.
 */
public class DaoFactoryInitializer {

    public static Map<Class, DaoCreator> initialize() {
        Map<Class, DaoCreator> map = new HashMap<>();
        map.put(Faculty.class, new FacultyDaoCreator());
        map.put(RegisteredUser.class, new RegisteredUserDaoCreator());
        map.put(RequiredSubject.class, new RequiredSubjectDaoCreator());
        map.put(Role.class, new RoleDaoCreator());
        map.put(Statement.class, new StatementDaoCreator());
        map.put(Subject.class, new SubjectDaoCreator());
        map.put(SubjectName.class, new SubjectNameDaoCreator());
        map.put(User.class, new UserDaoCreator());
        return map;
    }
}
