import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

    private static String brokerURL = "tcp://localhost:61616";
    private static transient ConnectionFactory factory;
    private transient Connection connection;
    private transient Session session;
    private transient MessageProducer producer;
    
    private static int id = 1000000;
    
    private String jobs[] = new String[]{"suspend", "delete"};
    
    public Producer() throws JMSException {
    	factory = new ActiveMQConnectionFactory(brokerURL);
    	connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(null);
    }    
    
    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }    
    
	public static void main(String[] args) throws JMSException {
    	    Producer producer = new Producer();
            producer.sendMessage();

            producer.close();
	}
	
    public void sendMessage() throws JMSException {
        Destination destination = session.createQueue("JOBS");
        Message message = session.createObjectMessage(id);
        producer.send(destination, message);
    }
}