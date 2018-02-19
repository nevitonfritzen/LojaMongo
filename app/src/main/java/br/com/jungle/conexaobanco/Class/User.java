package br.com.jungle.conexaobanco.Class;

/**
 * Created by neviton on 15/02/2018.
 */

public class User {

    private Id _id;
    private String user;

    public Id get_id() {
        return _id;
    }

    public void set_id(Id _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
