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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Human human = (Human) o;

        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        if (login != null ? !login.equals(human.login) : human.login != null) return false;
        return password != null ? password.equals(human.password) : human.password == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", name=" + name;
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
