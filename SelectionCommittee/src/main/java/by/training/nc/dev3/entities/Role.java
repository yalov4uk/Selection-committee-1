package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class Role extends Entity {

    private static final long serialVersionUID = 1L;
    private static int count = 0;

    private String name;

    public Role() {
        super(count++);
    }

    public Role(String name) {
        super(count++);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                super.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
