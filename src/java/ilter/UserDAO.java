/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ilter
 */
@ManagedBean
@SessionScoped
public class UserDAO {

    static String username;
    static String pass;
    static String query = "SELECT username, password FROM user_table";
    static PreparedStatement ps;
    static Statement state;
    static Connection conn;

    public static boolean login(String inputname, String inputpass) throws SQLException {
        ResultSet rs;
        try {
            conn = Postgres.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(query);
            System.out.println(inputname);
            while (rs.next()) {
                username = rs.getString("username");
                pass = rs.getString("password");
                if (username.equals(inputname) && pass.equals(inputpass)) {
                    return true;
                }
            }
        } finally {
            conn.close();
        }
        return false;
    }
}
