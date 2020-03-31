/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.domain;

import java.sql.*;

public class Database {

    private Connection db;

    public Database() throws SQLException {
        try {
            this.db = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException e) {
            System.out.println("Error. Database not found.");
        }
    }

    public boolean insertUser(String name) throws SQLException {
        PreparedStatement p = db.prepareStatement("INSERT INTO Users (name) VALUES(?)");
        p.setString(1, name);

        p.executeUpdate();
        return true;
    }
}
