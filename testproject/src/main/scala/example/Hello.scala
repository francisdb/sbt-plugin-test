package example

object Hello extends Greeting with App {
  println(greeting + " " + HelloLib.foo)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
