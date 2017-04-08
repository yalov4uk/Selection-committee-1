package by.training.nc.dev3.initializers;

import by.training.nc.dev3.entities.SubjectName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class SubjectNameInitializer {

    public static List<SubjectName> initialize() {
        List<SubjectName> subjectNames = new ArrayList<>();
        subjectNames.add(new SubjectName("Certificate"));
        subjectNames.add(new SubjectName("Mathematics"));
        subjectNames.add(new SubjectName("Chemistry"));
        subjectNames.add(new SubjectName("Physics"));
        subjectNames.add(new SubjectName("Informatics"));
        subjectNames.add(new SubjectName("Language"));
        return subjectNames;
    }
}
