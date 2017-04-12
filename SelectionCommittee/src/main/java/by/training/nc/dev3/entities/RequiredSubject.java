package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * Created by Valera Yalov4uk on 4/12/2017.
 */
public class RequiredSubject extends Entity{
    private int facultyId;
    private int subjectNameId;
    private static int count = 0;

    public RequiredSubject(int facultyId, int subjectNameId) {
        super(count++);
        this.facultyId = facultyId;
        this.subjectNameId = subjectNameId;
    }

    public RequiredSubject(int id, int facultyId, int subjectNameId) {
        super(id);
        this.facultyId = facultyId;
        this.subjectNameId = subjectNameId;
    }

    public int getSubjectNameId() {
        return subjectNameId;
    }

    public void setSubjectNameId(int userId) {
        this.subjectNameId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
}
