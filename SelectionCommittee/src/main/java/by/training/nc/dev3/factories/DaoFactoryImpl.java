package by.training.nc.dev3.factories;

import by.training.nc.dev3.entities.*;
import by.training.nc.dev3.factories.creators.*;
import by.training.nc.dev3.iterfaces.dao.BaseDao;
import by.training.nc.dev3.iterfaces.factories.DaoCreator;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import com.jolbox.bonecp.BoneCP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/14/2017.
 */
public class DaoFactoryImpl implements DaoFactory {

    private BoneCP pool;
    private Map<Class, DaoCreator> map;

    public DaoFactoryImpl(BoneCP pool) {
        this.pool = pool;
        map = initMap();
    }

    public BaseDao getDao(Class name){
        return map.get(name).create(pool);
    }

    private Map<Class, DaoCreator> initMap(){
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
