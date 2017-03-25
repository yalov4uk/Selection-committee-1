package by.training.nc.dev3.iterfaces;

/**
 * Created by Valera Yalov4uk on 3/25/2017.
 */
public interface ISerializeManager<T> {
    boolean serialize(T object);

    T deserialize();
}
