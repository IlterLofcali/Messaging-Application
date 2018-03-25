/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ilter
 */
public class Postgres {
   public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost/my_db";
        
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,"postgres","1234");
                                                System.out.println("Connection completed.");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}
     public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
