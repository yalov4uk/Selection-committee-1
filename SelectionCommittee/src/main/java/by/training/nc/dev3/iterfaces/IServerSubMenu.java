package by.training.nc.dev3.iterfaces;

import java.sql.SQLException;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IServerSubMenu {

    void menuAdmin() throws SQLException;

    void menuEnrollee() throws SQLException;
}
