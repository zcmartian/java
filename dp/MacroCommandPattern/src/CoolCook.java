/**
 * Created by marszhou on 16/9/7.
 */
public class CoolCook implements ICook {
    @Override
    public void cook(String name) {
        System.out.println("凉菜" + name + "已经做好,本厨师正在装盘");
    }
}
