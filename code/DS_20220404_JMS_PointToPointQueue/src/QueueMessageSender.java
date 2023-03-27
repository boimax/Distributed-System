import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.MessageProducer;

public class QueueMessageSender {
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;

	public void enqueueMessage() throws Exception {
		BufferedReader inlineReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("QUEUE NAME");
			MessageProducer messageProducer = session.createProducer(destination);
			String messageContent = null;
			while (true) {
				System.out.println("Enter new messages to send or 'stop' to exit!!!");
				messageContent = inlineReader.readLine();
				if (messageContent.equals("stop"))
					break;
				TextMessage textMessage = session.createTextMessage(messageContent);
				messageProducer.send(textMessage);
				System.out.println("Sending Message : " + messageContent);
			}
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		QueueMessageSender QMS = new QueueMessageSender();
		QMS.enqueueMessage();
	}
}