package mars.zhou;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) throws PerformanceException {
        // TODO Auto-generated method stub
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:spring-idol.xml");

        // Performer p = (Performer) ctx.getBean("kenny");
        Performer p = (Performer) ctx.getBean("hank");
        p.perform();
        ctx.registerShutdownHook();
    }

}
