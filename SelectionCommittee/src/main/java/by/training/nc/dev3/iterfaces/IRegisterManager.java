package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.entities.User;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IRegisterManager {

    User register(List<User> users, IInOutManager inOutManager);
}
