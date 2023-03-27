import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.MessageConsumer;

public class QueueMessageReceiver {
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	
	public void startReceivingMessage() {
		BufferedReader inlineReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("QUEUE NAME");
			MessageConsumer messageConsumer = session.createConsumer(destination);
			while (true) {
				Message message = messageConsumer.receive();
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					System.out.println(textMessage.getText());
				} 
				else {
					throw new JMSException("Error! Not TextMessage type");
				}
			}
		} 
		catch (JMSException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		QueueMessageReceiver QMR = new QueueMessageReceiver();
		QMR.startReceivingMessage();
	}
}