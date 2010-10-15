package com.cflewis.jms

import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import javax.jms.ConnectionFactory
import org.apache.activemq.ActiveMQConnectionFactory


@RunWith(classOf[JUnitRunner])
class JmsTest extends FlatSpec {

  "A Producer" should "send messages" in {
      val brokerUrl = "tcp://localhost:61616"

      val factory:ConnectionFactory = new ActiveMQConnectionFactory(brokerUrl)
      val producer:Producer = new Producer(factory, "test")
      producer.run()
      producer.close()
  }


  "A Consumer" should "consume messages" is (pending)
}

