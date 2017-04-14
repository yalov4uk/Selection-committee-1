package by.training.nc.dev3.entities;

import by.training.nc.dev3.abstracts.Entity;

/**
 * Created by Valera Yalov4uk on 4/8/2017.
 */
public class Role extends Entity {

    private static int count = 0;

    private String name;

    public Role() {
        super(count++);
    }

    public Role(String name) {
        super(count++);
        this.name = name;
    }

    public Role(int id, String name) {
        super(id);
        this.name = name;
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
        if (!(o instanceof Role)) return false;
        if (!super.equals(o)) return false;

        Role role = (Role) o;

        return name != null ? name.equals(role.name) : role.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                super.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
