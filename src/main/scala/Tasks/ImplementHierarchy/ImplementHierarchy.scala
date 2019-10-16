package Tasks.ImplementHierarchy


object ImplementHierarchy extends App {
  val c = new Circle("Red",9 , true)
  println(c)
  println("Radius: "+c.radius)
  println(c.radius(7))

  val s = new Square("Yellow", true, 5,5,5)
  println("Size side: "+ s.side)
  println(s.color("Blue"))

  val r = new Rectangle("Green", false, 4, 3)
  println(r)
  println("Width: " +r.width +" Length: "+r.length)

}

