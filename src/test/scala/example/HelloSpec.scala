package example

import childExample.HelloFromChildTest

class HelloSpec extends HelloFromChildTest {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "HelloFromChild"
  }
}
