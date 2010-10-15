package com.cflewis.jms;

import javax.jms._
import org.apache.activemq.ActiveMQConnectionFactory;

class Consumer(brokerUrl:String) extends MessageListener {
    val factory = new ActiveMQConnectionFactory(brokerUrl)
    val connection = factory.createConnection()
    connection.start()
    val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
    val destination = session.createQueue("test")
    val consumer = session.createConsumer(destination)
    consumer.setMessageListener(this)
    
    def onMessage(message:Message):Unit = {
        if (message.isInstanceOf[TextMessage]) {
            val textMessage = message.asInstanceOf[TextMessage]
            println("Message recieved: " + textMessage.getText())
        } else {
            println("Oops, not a text message")
        }
    }
}

object ConsumerApp extends Application {
  val consumer = new Consumer("tcp://localhost:61616")
}
