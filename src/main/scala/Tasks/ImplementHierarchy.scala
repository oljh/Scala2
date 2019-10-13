package Tasks

object ImplementHierarchy {

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


class Circle(c:String, f:Boolean, radius: Double) extends Shape (c:String, f:Boolean) {

  def radius(r: Double): Circle = ???

  override def color(c: String): Shape = ???
  override def filled(f: Boolean): Shape = ???
}

class Rectangle(color:String, filled:Boolean, width: Double, length: Double) extends Shape(color:String, filled:Boolean){

  def width(w: Double): Rectangle = this
  def length(l: Double): Rectangle = this

  override def color(c: String): Shape = ???
  override def filled(f: Boolean): Shape = ???
}

class Square(color:String, filled:Boolean, width: Double, length: Double, side: Double) extends Rectangle(color:String, filled:Boolean, width: Double, length: Double){
  override def width(w: Double): Rectangle = super.width(side)

  override def length(l: Double): Rectangle = super.length(side)

  def side(s: Double): Square = ???
}


