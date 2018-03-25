/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilter;

import static ilter.GonderMesaj.conn;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ilter
 */
@ManagedBean
@SessionScoped
public class Gonder {
      static String receiver, message;
         String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
         Gonder.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        Gonder.message = message;
    }
        static PreparedStatement p;
     public  void setGonder() throws SQLException {                  //Gönderme eylemi
   
      
     
        String query_get="INSERT INTO messaging(sender_name, receiver_name, message_date, message) VALUES (?,?,?,?)";
        
        if(conn==null){
            try{
        conn = Postgres.getConnection();
        p = conn.prepareStatement(query_get);
        p.setString(1,s );
        p.setString(2, receiver);      //Listeden Seçilen İsim
        p.setDate(3,Date.valueOf(LocalDate.now()));
        p.setString(4, message);    //Mesaj İçeriği
        p.executeUpdate();
            }finally{
            conn.close();
            p.close();
            }
        
        }
    }
}
