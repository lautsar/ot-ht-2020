/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.domain;

/**
 *
 * @author lautanas
 */
public class User {

    private String user;
    private Database db;

    public User(String user) {
        this.user = user;
    }

    public User(String user, Database db) {
        this.user = user;
        this.db = db;
    }

    public String getName() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
