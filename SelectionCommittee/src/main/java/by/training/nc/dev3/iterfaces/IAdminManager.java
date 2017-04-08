package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.Faculty;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.entities.User;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IAdminManager {

    Statement createStatement(List<Faculty> faculties, int id);

    void setAdmin(User admin);
}
