package by.training.nc.dev3.initializers;

import by.training.nc.dev3.entities.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class RoleInitializer {
    public static List<Role> initialize() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("enrollee"));
        roles.add(new Role("admin"));
        return roles;
    }
}
