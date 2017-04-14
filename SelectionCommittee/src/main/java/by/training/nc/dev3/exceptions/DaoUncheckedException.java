package by.training.nc.dev3.exceptions;

/**
 * Created by Valera Yalov4uk on 4/9/2017.
 */
public class DaoUncheckedException extends RuntimeException {

    public DaoUncheckedException() {
    }

    public DaoUncheckedException(String msg) {
        super(msg);
    }

    public DaoUncheckedException(Exception e) {
        super(e);
    }
}
