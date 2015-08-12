package mars;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;  
  
import com.ibatis.common.resources.Resources;  
import com.ibatis.sqlmap.client.SqlMapClient;  
import com.ibatis.sqlmap.client.SqlMapClientBuilder;  
public class IbatisExample {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String resource = "mars/SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		List<User> list = new ArrayList<User>();
		list = sqlMap.queryForList("getAllUsers", "EMPLOYEE");

		int s = list.size();
		System.out.println("Selected " + s + " records.");

		System.out.println("USERID\tUSERNAME\tPASSWORD\tGROUP");

		for (int i = 0; i < s; i++) {
			System.out.print(list.get(i).getUserid() + "\t");
			System.out.print(list.get(i).getUsername() + "\t\t");
			System.out.print(list.get(i).getPassword() + "\t\t");
			System.out.println(list.get(i).getGroupname());
		}
		
		System.out.print("");
		
		User _user = new User();
		_user = (User) sqlMap.queryForObject("getUserById", 5);
		System.out.println("USERID\tUSERNAME\tPASSWORD\tGROUP");
		System.out.print(_user.getUserid() + "\t");
		System.out.print(_user.getUsername() + "\t\t");
		System.out.print(_user.getPassword() + "\t\t");
		System.out.println(_user.getGroupname());
	}

}
