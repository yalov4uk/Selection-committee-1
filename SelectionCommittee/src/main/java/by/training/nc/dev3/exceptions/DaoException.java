package by.training.nc.dev3.exceptions;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class DaoException extends Exception {
    private static final long serialVersionUID = 1L;

    public DaoException() {
    }

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(Exception e) {
        super(e);
    }
}
