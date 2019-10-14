package Tasks.ImplementHierarchy

class Rectangle(val color: String,val filled: Boolean,val width: Double,val length: Double) extends Shape(color: String, filled: Boolean) {
  import Rectangle._

  def width(w: Double): Rectangle = new Rectangle(color, filled, w, length)

  def length(l: Double): Rectangle = new Rectangle(color, filled, width, l)


  override def perimeter: Double = calculatePerimeter(width: Double, length: Double)

  override def area: Double = calculateArea(width: Double, length: Double)


  override def color(c: String): Rectangle = new Rectangle(c, filled, width, length)

  override def filled(f: Boolean): Rectangle = new Rectangle(color, f, width, length)


  override def toString = s"Rectangle(width = $width, length = $length, color = $color, filled = $filled, perimeter = $perimeter,area = $area)"
}

object Rectangle {
  private def calculateArea(width: Double, length: Double): Double = 2 * width + 2 * length

  private def calculatePerimeter(width: Double, length: Double): Double = width * length
}
