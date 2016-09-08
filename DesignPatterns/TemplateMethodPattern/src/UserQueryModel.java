import java.sql.*;

/**
 * Created by marszhou on 16/9/8.
 */
public class UserQueryModel extends UserModel{
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

    public void create(UserModel um) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into student values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, um.getUid());
            preparedStatement.setString(2, um.getName());
            preparedStatement.setString(3, um.getSex());
            preparedStatement.setDate(4, new Date(um.getBirthday().getTime()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
    }
}
