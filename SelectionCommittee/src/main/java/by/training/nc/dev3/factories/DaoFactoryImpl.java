package by.training.nc.dev3.factories;

import by.training.nc.dev3.initializers.DaoFactoryInitializer;
import by.training.nc.dev3.iterfaces.dao.BaseDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.creators.DaoCreator;
import com.jolbox.bonecp.BoneCP;

import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/14/2017.
 */
public class DaoFactoryImpl implements DaoFactory {

    private BoneCP pool;
    private Map<Class, DaoCreator> map;

    public DaoFactoryImpl(BoneCP pool) {
        this.pool = pool;
        map = DaoFactoryInitializer.initialize();
    }

    public BaseDao getDao(Class name){
        return map.get(name).create(pool);
    }
}
