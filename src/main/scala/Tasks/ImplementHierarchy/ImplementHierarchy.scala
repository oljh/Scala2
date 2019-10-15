package Tasks.ImplementHierarchy


object ImplementHierarchy extends App {
  val c = new Circle("Red", true, 9)
  println(c)
  println(c.radius)
  println(c.radius(7))

  val s = Square("Yellow", true, 5)
  println(s.color("Blue"))

  val r = new Rectangle("Green", false, 2, 3)
  println(r)



}

