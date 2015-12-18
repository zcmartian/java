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
        // User user = (User) sqlMap.queryForObject("getUserById", 1);
        // System.out.println("Selected " + user.getUserid() +
        // user.getUsername()
        // + user.getGroupname());
        //
        // list = sqlMap.queryForList("getAllUsers", "dianing");
        // int s = list.size();
        // System.out.println("Selected " + s + " records.");
        //
        // System.out.println("USERID\tUSERNAME\tPASSWORD\tGROUP");
        //
        // for (int i = 0; i < s; i++) {
        // System.out.print(list.get(i).getUserid() + "\t");
        // System.out.print(list.get(i).getUsername() + "\t\t");
        // System.out.print(list.get(i).getPassword() + "\t\t");
        // System.out.println(list.get(i).getGroupname());
        // }

        // List<Integer> ids = sqlMap.queryForList("getUserIdValues", null);
        // s = ids.size();
        // for (int id : ids) {
        // System.out.println(id);
        // }

        // sqlMap.update("updateGroupName", new String("dianping"));
        // list = sqlMap.queryForList("getAllUsers", "dianping");
        // for (User _user : list) {
        // System.out.print(_user.getUserid() + "\t");
        // System.out.print(_user.getUsername() + "\t\t");
        // System.out.print(_user.getPassword() + "\t\t");
        // System.out.println(_user.getGroupname());
        // }

        User newUser = new User();
        newUser.setUserid(10);
        newUser.setUsername("mars.zhou");
        newUser.setPassword("root");
        newUser.setGroupname("poi");
        sqlMap.insert("insertIntoUsers", newUser);
        list = sqlMap.queryForList("getAll");
        for (User user : list) {
            System.out.print(user.getUserid() + "\t");
            System.out.print(user.getUsername() + "\t\t");
            System.out.print(user.getPassword() + "\t\t");
            System.out.println(user.getGroupname());
        }
    }

}
