import java.sql.Date;
import java.util.Collection;

/**
 * Created by marszhou on 16/9/9.
 */
public class Client {
    public static void main(String[] args) {
        UserJDBC uj = new UserJDBC();
        UserModel userModel = new UserModel();
//        userModel.setUid("001");
//        userModel.setName("mars");
//        userModel.setSex("male");
//        userModel.setBirthday(new Date(System.currentTimeMillis()));
//        uj.create(userModel);
        UserQueryModel userQueryModel = new UserQueryModel();
//        userQueryModel.setUid("001");
//        Collection<UserModel> collection = uj.getByCondition(userQueryModel);
//        for (UserModel um : collection) {
//            System.out.println(um);
//        }
        userModel = new UserModel();
        userModel.setUid("001");
        userModel.setName("marszhou");
        userModel.setSex("male");
        userModel.setBirthday(new Date(System.currentTimeMillis()));
        uj.update(userModel);
        Collection<UserModel> collection = uj.getByCondition(userQueryModel);
        for (UserModel um : collection) {
            System.out.println(um);
        }

    }
}
