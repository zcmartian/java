import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by marszhou on 16/9/9.
 */
public abstract class JDBCTemplate {
    protected final static int CREATE = 1;
    protected final static int UPDATE = 2;
    protected final static int DELETE = 3;
    protected final static int CONDITION = 4;

    public final void create(Object obj) {
        String sql = getMainSql(CREATE);
        executeUpdate(sql, CREATE, obj);
    }

    public final void update(Object obj) {
        String sql = getMainSql(UPDATE);
        executeUpdate(sql, UPDATE, obj);
    }

    public final void delete(Object obj) {
        String sql = getMainSql(DELETE);
        executeUpdate(sql, DELETE, obj);
    }

    public final Collection getByCondition(Object qm) {
        String sql = getMainSql(CONDITION);
        return getByCondition(sql, qm);
    }

    protected abstract String getMainSql(int type);

    protected abstract void setUpdateSqlValue(int type, PreparedStatement preparedStatement, Object object)
            throws Exception;

    protected abstract String prepareQuerySql(String sql, Object qm);

    protected abstract void setQuerySqlValue(PreparedStatement preparedStatement, Object qm) throws Exception;

    protected abstract Object rs2Object(ResultSet resultSet) throws Exception;

    protected Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }

    protected Collection getByCondition(String sql, Object qm) {
        Collection collection = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            sql = prepareQuerySql(sql, qm);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setQuerySqlValue(preparedStatement, qm);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                collection.add(rs2Object(resultSet));
            }
            resultSet.close();
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
        return collection;
    }

    protected Collection executeUpdate(String sql, int type, Object object) {
        Collection collection = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setUpdateSqlValue(type, preparedStatement, object);
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
        return collection;
    }
}
