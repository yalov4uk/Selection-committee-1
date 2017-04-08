package by.training.nc.dev3.initializers;

import by.training.nc.dev3.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class UserInitializer {
    public static List<User> initialize() {
        List<User> users = new ArrayList<>();
        users.add(new User("Admin1", "admin", "admin", 2));
        return users;
    }
}
