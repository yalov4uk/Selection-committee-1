package by.training.nc.dev3.initializers;

import com.jolbox.bonecp.BoneCPConfig;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public class BoneCPConf {
    private static final String URL_FIXED = "jdbc:mysql://localhost:3306/selection_committee?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static BoneCPConfig initialize() {
        BoneCPConfig config = new BoneCPConfig();
        config.setJdbcUrl(URL_FIXED);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setMinConnectionsPerPartition(5);
        config.setMaxConnectionsPerPartition(10);
        config.setPartitionCount(1);
        return config;
    }
}
