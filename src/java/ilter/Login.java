/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilter;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ilter
 */
@ManagedBean
@SessionScoped
public class Login {
    String input, p;
    public String login_method() throws SQLException{
        if(UserDAO.login(input,p)){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username",input);
            Gonder g = new Gonder();
            g.setS(input);
            return "/user_page.xhtml?faces-redirect=true";
        }
      return "/user_page.xhtml?faces-redirect=true";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
    
    public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "/login.xhtml?faces-redirect=true";
	}
}
