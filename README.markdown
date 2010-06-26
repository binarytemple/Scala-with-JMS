JMS Scala Test
==============
A probably-way-too-Java-esque Scala program that consumes JMS messages with ActiveMQ. It's adapted from the excellent [Java/Maven/ActiveMQ tutorial](http://pookey.co.uk/blog/archives/73-Playing-with-ActiveMQ-using-Maven.html) by Ian P. Christian.

To run it, start up ActiveMQ:
	mvn org.apache.activemq.tooling:maven-activemq-plugin:5.3.0:run

Run the Producer with:
    mvn compile exec:java -Dexec.mainClass=com.cflewis.jms.ProducerApp

Run the Consumer with:
	mvn compile exec:java -Dexec.mainClass=com.cflewis.jms.ConsumerApp
	
License
=======
This code is released under a [BSD license](http://creativecommons.org/licenses/BSD/).