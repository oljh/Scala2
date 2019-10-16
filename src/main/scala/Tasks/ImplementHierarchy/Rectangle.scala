package Tasks.ImplementHierarchy

class Rectangle(val color: String, val filled: Boolean, val width: Double, val length: Double) extends Shape(color: String, filled: Boolean) {

  import Rectangle._

  def rectangle(color: String = this.color,
                filled: Boolean = this.filled,
                width: Double = this.width,
                length: Double = this.length): Rectangle = new Rectangle(color: String, filled: Boolean, width: Double, length: Double)


  def width(w: Double): Rectangle = rectangle(width = w)

  def length(l: Double): Rectangle = rectangle(length = l)


  override def perimeter: Double = calculatePerimeter(width: Double, length: Double)

  override def area: Double = calculateArea(width: Double, length: Double)


  override def color(c: String): Rectangle = rectangle(color = c)

  override def filled(f: Boolean): Rectangle = rectangle(filled = f)


  override def toString = s"Rectangle(color = $color, filled = $filled, width = $width, length = $length, perimeter = $perimeter,area = $area)"

}

object Rectangle {
  def apply(color: String, filled: Boolean, width: Double, length: Double): Rectangle = new Rectangle(
    color, filled, width, length)

  def calculateArea(width: Double, length: Double): Double = width * length

  def calculatePerimeter(width: Double, length: Double): Double = 2 * (width + length)
}
