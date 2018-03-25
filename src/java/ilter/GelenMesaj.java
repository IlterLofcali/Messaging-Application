/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilter;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

/**
 *
 * @author ilter
 */
@ManagedBean(name = "gelenMesaj")
@SessionScoped
public class GelenMesaj implements Serializable{
    //String query = "SELECT messaging.sender_name, messaging.receiver_name, messaging.message_date, messaging.message, user_table.username FROM messaging INNER JOIN user_table ON user_table.username = messaging.receiver_name WHERE receiver_name = ?;";
     String query = "SELECT messaging.sender_name, messaging.receiver_name, messaging.message_date, messaging.message FROM messaging;";
    ResultSet rs;
    PreparedStatement ps;
    Connection conn; 
   
    public List <MsgListInst> getList() throws SQLException{    //Receiver giriş yapan(şu anki)
        List <MsgListInst> newList = new ArrayList<>();
    if(conn == null){     
        try{
    conn  = Postgres.getConnection();
    ps = conn.prepareStatement(query);
    rs = ps.executeQuery();
//    ps.setString(1, s);
    while(rs.next()){
        MsgListInst list = new MsgListInst();
        list.setSender_name(rs.getString("sender_name"));
        list.setReceiver_name(rs.getString("receiver_name"));
        list.setMessage_date(rs.getDate("message_date"));
        list.setMessage(rs.getString("message"));
        newList.add(list);
    }
        }
    finally{
            conn.close();
            }
        }
    return newList;
    }
    
    
}
