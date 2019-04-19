package mars.zhou;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:BraveKnight.xml");
        IKnight knight = (IKnight) context.getBean("knight");

        knight.EmbarkOnQuest();
    }

}
