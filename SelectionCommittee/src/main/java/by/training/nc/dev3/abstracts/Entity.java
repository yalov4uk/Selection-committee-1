/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.abstracts;

import java.io.Serializable;
import java.util.Random;

/**
 * @author Valera Yalov4uk
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int id;

    public Entity() {
        Random rnd = new Random(System.currentTimeMillis());
        this.id = rnd.nextInt(10000);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
