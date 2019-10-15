package Tasks.ImplementHierarchy

class Circle(val color: String,val filled: Boolean, val radius: Double) extends Shape(color: String, filled: Boolean) {

  import Circle._

  def radius(r: Double): Circle = new Circle(color, filled, r)

  override def perimeter: Double = calculatePerimeter(radius)

  override def area: Double = calculateArea(radius)

  override def color(c: String): Circle = new Circle(c, filled, radius)

  override def filled(f: Boolean): Circle = new Circle(color, f, radius)

  override def toString = s"Circle(radius = $radius,color = $color, filled = $filled, perimeter = $perimeter,area = $area)"

}

object Circle {
  private def calculateArea(radius: Double): Double = Math.PI * Math.pow(radius, 2.0)

  private def calculatePerimeter(radius: Double): Double = 2 * Math.PI * radius
}



