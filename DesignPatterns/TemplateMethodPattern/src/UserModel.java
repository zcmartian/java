import java.util.Date;

/**
 * Created by marszhou on 16/9/8.
 */
public class UserModel {
    private String uid;
    private String name;
    private String sex;
    private Date birthday;

    @Override
    public String toString() {
        return "UserModel{" + "uid='" + uid + '\'' + ", name='" + name + '\'' + ", sex='" + sex + '\'' + ", birthday="
                + birthday + '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
