package by.training.nc.dev3.iterfaces.factories.creators;

import by.training.nc.dev3.iterfaces.dao.BaseDao;
import com.jolbox.bonecp.BoneCP;

/**
 * Created by Valera Yalov4uk on 4/14/2017.
 */
public interface DaoCreator {

    BaseDao create(BoneCP pool);
}
