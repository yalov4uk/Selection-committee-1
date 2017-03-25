/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.training.nc.dev3.abstracts;

import by.training.nc.dev3.iterfaces.IServerSubMenu;

/**
 * @author Valera Yalov4uk
 */
public abstract class Human extends Entity {

    private static final long serialVersionUID = 1L;

    protected String name;
    protected String login;
    protected String password;

    public abstract void goNextMenu(IServerSubMenu server);

    public Human() {
        super();
    }

    public Human(String name) {
        super();
        this.name = name;
    }

    public Human(String name, String login, String password) {
        super();
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Human other = (Human) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null)
                : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
