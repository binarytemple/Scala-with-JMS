package com.cflewis.jms

import javax.jms._
import org.apache.activemq.ActiveMQConnectionFactory

class Producer(factory:ConnectionFactory, queueName:String) {
    // private ConnectionFactory factory;
    // private Connection connection;
    // private Session session;
    // private MessageProducer producer;
    
    private var connection = factory.createConnection()
    connection.start()
    private var session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
    private var destination = session.createQueue(queueName)
    private var producer = session.createProducer(destination)
    
    def run() = {
        for (i <- 0 until 100) {
            println("Sending message")
            var message = session.createTextMessage("Number " + i + ": Hello world!")
            producer.send(message)
        }
    }
    
    def close() = {
        if (connection != null) { connection.close() }
    }
}


object ProducerApp extends Application {
  val brokerUrl = "tcp://localhost:61616"
  
  val factory:ConnectionFactory = new ActiveMQConnectionFactory(brokerUrl)
  val producer:Producer = new Producer(factory, "test")
  producer.run()
  producer.close()
}
