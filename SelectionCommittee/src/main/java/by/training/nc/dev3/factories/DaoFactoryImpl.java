package by.training.nc.dev3.factories;

import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.initializers.BoneCPConfInitializer;
import by.training.nc.dev3.initializers.DaoFactoryInitializer;
import by.training.nc.dev3.iterfaces.dao.BaseDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.creators.DaoCreator;
import com.jolbox.bonecp.BoneCP;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Valera Yalov4uk on 4/14/2017.
 */
public class DaoFactoryImpl implements DaoFactory {

    private static  BoneCP pool;
    private Map<Class, DaoCreator> map;

    private DaoFactoryImpl(BoneCP pool) {
        this.pool = pool;
        map = DaoFactoryInitializer.initialize();
    }

    public BaseDao getDao(Class name){
        if (name != null && map.containsKey(name)) {
            return map.get(name).create(pool);
        }
        return null;
    }

    private static DaoFactory ourInstance;

    public static DaoFactory getInstance() {
        if (ourInstance == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                pool = new BoneCP(BoneCPConfInitializer.initialize());
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Cannot find the driver in the classpath!", e);
            } catch (SQLException e) {
                throw new DaoUncheckedException("BoneCP init error");
            }
            ourInstance = new DaoFactoryImpl(pool);
        }
        return ourInstance;
    }
}
