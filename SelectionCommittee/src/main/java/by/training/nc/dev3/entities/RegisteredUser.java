package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * Created by Valera Yalov4uk on 4/11/2017.
 */
public class RegisteredUser extends Entity {
    private int facultyId;
    private int userId;
    private static int count = 0;

    public RegisteredUser(int facultyId, int userId) {
        super(count++);
        this.facultyId = facultyId;
        this.userId = userId;
    }

    public RegisteredUser(int id, int facultyId, int userId) {
        super(id);
        this.facultyId = facultyId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
}
