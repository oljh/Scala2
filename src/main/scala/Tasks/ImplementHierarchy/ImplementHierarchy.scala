package Tasks.ImplementHierarchy


object ImplementHierarchy extends App {
  val c = new Circle("red", true, 3.14)
  println(c.radius(12))
  val r = new Rectangle("Green",false,2,3)
  println(r.length(5))

  val s = new Square("Magenta", filled = true, width = )
  println(new Rectangle("Green",false,2,3))
  println(new Square("Yellow",true,2,3,5))


}

