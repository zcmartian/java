package mars.zhou;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainApplication {

    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //
        // HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        // obj.getMessage();

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld bean = (HelloWorld) bf.getBean("helloWorld");
        bean.getMessage();
    }

}
