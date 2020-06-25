import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by marszhou on 16/9/8.
 */
public class UserQueryModel extends UserModel {
    private String name2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
}
