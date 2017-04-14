package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class SubjectName extends Entity {

    private static int count = 0;

    private String name;

    public SubjectName() {
        super(count++);
    }

    public SubjectName(String name) {
        super(count++);
        this.name = name;
    }

    public SubjectName(int id, String name) {
        super(id);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectName)) return false;
        if (!super.equals(o)) return false;

        SubjectName that = (SubjectName) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubjectName{" +
                super.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
