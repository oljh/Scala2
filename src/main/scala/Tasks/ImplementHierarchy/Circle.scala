package Tasks.ImplementHierarchy

class Circle(val color: String, val radius: Double, val filled: Boolean) extends Shape(color: String, filled: Boolean) {

  import Circle._

  def circle(color: String = this.color,
             radius: Double = this.radius,
             filled: Boolean = this.filled): Circle = new Circle(color, radius, filled)

  def radius(r: Double): Circle = circle(radius = r)

  override def perimeter: Double = calculatePerimeter(radius)

  override def area: Double = calculateArea(radius)

  override def color(c: String): Circle = circle(color = c)

  override def filled(f: Boolean): Circle = circle(filled = f)

  override def toString = s"Circle(color = $color, filled = $filled,radius = $radius, perimeter = $perimeter,area = $area)"

}

object Circle {
  def apply(color: String, radius: Double, filled: Boolean): Circle = new Circle(color, radius, filled)

  private def calculateArea(radius: Double): Double = Math.PI * Math.pow(radius, 2)

  private def calculatePerimeter(radius: Double): Double = 2 * Math.PI * radius
}




