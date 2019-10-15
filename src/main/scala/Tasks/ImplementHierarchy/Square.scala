package Tasks.ImplementHierarchy

class Square(color: String, filled: Boolean, width: Double, length: Double, val side: Double) extends Rectangle(color: String, filled: Boolean, width: Double, length: Double) {
  import Square._

  def side(s: Double): Square = new Square(color, filled, s, s, s)

  override def width(w: Double): Rectangle = new Square(color, filled, side, side, side)

  override def length(l: Double): Rectangle = new Square(color, filled, side, side, side)

  override def perimeter: Double = calculatePerimeter(side)

  override def area: Double = calculateArea(side)


  override def color(c: String): Square = new Square(c, filled, side, side, side)

  override def filled(f: Boolean): Square = new Square(color, f, side, side, side)

  override def toString = s"Square(side = $side,color = $color, filled = $filled, perimeter = $perimeter,area = $area)"
}

object Square {
  def apply(color: String, filled: Boolean, side: Double): Square = new Square(color, filled, side, side, side)

  private def calculateArea(side: Double): Double = Math.pow(side,2)

  private def calculatePerimeter(side: Double): Double = side*4
}

