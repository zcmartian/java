import java.util.Collection;

/**
 * Created by marszhou on 16/9/9.
 */
public class Client {
    public static void main(String[] args) {
        UserJDBC uj = new UserJDBC();
        UserQueryModel userQueryModel = new UserQueryModel();
        userQueryModel.setUid("001");
        Collection<UserModel> collection = uj.getByCondition(userQueryModel);
        for (UserModel um : collection) {
            System.out.println(um);
        }
    }
}
