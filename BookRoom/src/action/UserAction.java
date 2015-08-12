
package action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.TestDao;
import dao.TestDaoImpl;
import domain.Test;
import service.LoginFace;

public class UserAction extends ActionSupport
{

    public UserAction()
    {
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    public LoginFace getFace()
    {
        return face;
    }

    public void setFace(LoginFace face)
    {
        this.face = face;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


	public void setDao(TestDao dao) {
		this.dao = dao;
	}
	public String login()
    {
    	Test t=face.combine(getUsername(), getPassword());
    	List<Test> l = dao.queryTestName(t.getUsername());
    	for(int i=0;i<l.size();i++){
    		String password = l.get(i).getPassword();
    		if(this.password.equals(password)) 
    			return "success";
    		
    	}
            return "error";
           
    }
    public String register()
    {
    	Test t=face.combine(getUsername(), getPassword());
    	boolean b = dao.insertTest(t);
    	if(b==true) 
    		return "success";
    	else
    		return "error";
    }
	public String queryall() {
			List<Test> l1 = dao.queryTest();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("user", l1);
			return "success";
		}
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username=request.getParameter("username");
		Test t=face.combine(username, password);
	  	boolean b = dao.updateTest(t);
    	if(b==true) 
    		return "success";
    	else
    		return "error";
	}
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username=request.getParameter("username");
	  	boolean b = dao.deleteTest(username);
    	if(b==true) 
    		return "success";
    	else
    		return "error";
	}
    private String username;
    private String password;
    private LoginFace face;
    private TestDao dao;
}