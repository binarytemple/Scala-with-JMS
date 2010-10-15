package com.cflewis.jms

import org.specs._
import runner.{ScalaTestSuite, ConsoleRunner, JUnit4}


object MySpec extends Specification {
  "This wonderful system" should {
    "save the world" in {
      val list = Nil
      list must beEmpty
    	"hello world" must be matching("h.* w.*")
    }
  }
}

class MySpecTest extends JUnit4(MySpec)
class MySpecSuite extends ScalaTestSuite(MySpec)
object MySpecRunner extends ConsoleRunner(MySpec)

