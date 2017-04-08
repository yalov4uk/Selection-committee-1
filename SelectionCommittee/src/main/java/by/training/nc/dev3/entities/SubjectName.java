package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class SubjectName extends Entity {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    private String name;

    public SubjectName() {
        super(count++);
    }

    public SubjectName(String name) {
        super(count++);
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SubjectName.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectName{" +
                super.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
