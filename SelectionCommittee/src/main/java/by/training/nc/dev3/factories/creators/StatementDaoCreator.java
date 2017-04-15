package by.training.nc.dev3.factories.creators;

import by.training.nc.dev3.dao.StatementDaoImpl;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.BaseDao;
import by.training.nc.dev3.iterfaces.factories.creators.DaoCreator;
import com.jolbox.bonecp.BoneCP;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 4/14/2017.
 */
public class StatementDaoCreator implements DaoCreator {

    public BaseDao create(BoneCP pool){
        try {
            return new StatementDaoImpl(pool.getConnection());
        }
        catch (SQLException e){
            throw new DaoUncheckedException("Statement dao creator error");
        }
    }
}
