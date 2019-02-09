package example

import childExample.HelloFromChild

object Hello extends HelloFromChild with App {
  println(greeting)
}

