package by.training.nc.dev3.iterfaces;

import by.training.nc.dev3.abstracts.Human;

import java.util.List;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface IRegisterManager {

    Human register(List<Human> humans, IInOutManager inOutManager);
}
