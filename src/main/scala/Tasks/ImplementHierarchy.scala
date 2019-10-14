package Tasks

object ImplementHierarchy {
  val c = new Circle("", true, 3.14)
  c.radius(3.14)

}

trait GeometricObject {
  def perimeter(per: Double)

  def area(ar: Double)
}

abstract class Shape(color: String, filled: Boolean) extends GeometricObject {

  def perimeter(per: Double): Unit = ???

  def area(ar: Double): Unit = ???

  def color(c: String): Shape

  def filled(f: Boolean): Shape
}


class Circle(c: String, f: Boolean, radius: Double) extends Shape(c: String, f: Boolean) {
  val r:Double = radius

  def radius(r: Double): Circle = new Circle(c,f,r)

  override def perimeter(per: Double): Unit = ???

  override def area(ar: Double): Unit = ???

  override def color(c: String): Shape = new Circle(c,f,r)

  override def filled(f: Boolean): Shape = new Circle(c,f,r)
}


class Rectangle(color: String, filled: Boolean, width: Double, length: Double) extends Shape(color: String, filled: Boolean) {

  override def color(c: String): Shape = this

  override def filled(f: Boolean): Shape = this

  def width(w: Double): Rectangle = this

  def length(l: Double): Rectangle = this

}

class Square(color: String, filled: Boolean, width: Double, length: Double, side: Double) extends Rectangle(color: String, filled: Boolean, width: Double, length: Double) {

  override def width(w: Double): Rectangle = super.width(side)

  override def length(l: Double): Rectangle = super.length(side)

  def side(s: Double): Square = this
}


