import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by marszhou on 16/9/9.
 */
public class UserJDBC extends JDBCTemplate {
    @Override
    protected String getMainSql(int type) {
        String sql = "";
        if (type == CREATE) {
            sql = "insert into student values(?,?,?,?)";
        } else if (type == DELETE) {
            sql = "delete from student where uid=?";
        } else if (type == UPDATE) {
            sql = "update student set name=?,sex=? where uid=?";
        } else if (type == CONDITION) {
            sql = "select * from student where 1=1";
        }
        return sql;
    }

    @Override
    protected void setUpdateSqlValue(int type, PreparedStatement preparedStatement, Object object) throws Exception {
        if (type == CREATE) {
            setCreateValue(preparedStatement, (UserModel) object);
        } else if (type == DELETE) {
            setDeleteValue(preparedStatement, (UserModel) object);
        } else if (type == UPDATE) {
            setUpdateValue(preparedStatement, (UserModel) object);
        }
    }

    private void setCreateValue(PreparedStatement preparedStatement, UserModel um) throws Exception {
        preparedStatement.setString(1, um.getUid());
        preparedStatement.setString(2, um.getName());
        preparedStatement.setString(3, um.getSex());
    }
    private void setUpdateValue(PreparedStatement preparedStatement, UserModel um) throws Exception {
        preparedStatement.setString(1, um.getUid());
        preparedStatement.setString(2, um.getName());
        preparedStatement.setString(3, um.getSex());
    }
    private void setDeleteValue(PreparedStatement preparedStatement, UserModel um) throws Exception {
        preparedStatement.setString(1, um.getUid());
    }

    @Override
    protected String prepareQuerySql(String sql, Object qm) {
        UserQueryModel uqm = (UserQueryModel) qm;
        StringBuffer buffer = new StringBuffer();
        buffer.append(sql);
        if (uqm.getUid() != null && uqm.getUid().trim().length() > 0) {
            buffer.append(" and uid=?");
        }
        if (uqm.getName() != null && uqm.getName().trim().length() > 0) {
            buffer.append(" and getName like ? ");
        }
        if (uqm.getSex() != null && uqm.getSex().trim().length() > 0) {
            buffer.append(" and getSex = ? ");
        }
        if (uqm.getName2() != null && uqm.getName2().trim().length() > 0) {
            buffer.append(" and getName2 like ? ");
        }
        return buffer.toString();
    }

    @Override
    protected void setQuerySqlValue(PreparedStatement preparedStatement, Object qm) throws Exception {
        UserQueryModel uqm = (UserQueryModel) qm;
        int count = 1;
        if (uqm.getUid() != null && uqm.getUid().trim().length() > 0) {
            preparedStatement.setString(count, uqm.getUid());
            count++;
        }
        if (uqm.getName() != null && uqm.getName().trim().length() > 0) {
            preparedStatement.setString(count, "%" + uqm.getName() + "%");
            count++;
        }
        if (uqm.getSex() != null && uqm.getSex().trim().length() > 0) {
            preparedStatement.setString(count, uqm.getSex());
            count++;
        }
        if (uqm.getName2() != null && uqm.getName2().trim().length() > 0) {
            preparedStatement.setString(count, "%" + uqm.getName() + "%");
            count++;
        }
    }

    @Override
    protected Object rs2Object(ResultSet resultSet) throws Exception {
        UserModel um = new UserModel();
        String uid = resultSet.getString("uid");
        String name = resultSet.getString("name");
        String sex = resultSet.getString("sex");
        Date birthday = resultSet.getDate("birthday");
        um.setSex(sex);
        um.setName(name);
        um.setUid(uid);
        um.setBirthday(birthday);
        return um;
    }
}
