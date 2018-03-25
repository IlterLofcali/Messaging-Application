/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilter;

import com.sun.jmx.snmp.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ilter
 */
@ManagedBean
@SessionScoped
public class GonderMesaj {
    

  
    String query_get = "SELECT user_id, username FROM user_table";
    static Connection conn;
    static PreparedStatement p;
    static ResultSet r;

    public List<User_list> getList() throws SQLException {               //K. listesi
        List<User_list> my_list = new ArrayList<>();
        if (conn == null) {
            try {
                conn = Postgres.getConnection();
                p = conn.prepareStatement(query_get);
                r = p.executeQuery();
                while (r.next()) {
                    User_list newList = new User_list();
                    newList.setUser_id(r.getInt("user_id"));
                    newList.setUsername(r.getString("username"));
                    my_list.add(newList);
                }
            } finally {
                conn.close();
                
            }
            
        }
        return my_list;
    }
    
}
