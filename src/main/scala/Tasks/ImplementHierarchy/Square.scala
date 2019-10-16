package Tasks.ImplementHierarchy

class Square(color: String, filled: Boolean, width: Double, length: Double, val side: Double) extends Rectangle(color: String, filled: Boolean, width: Double, length: Double) {

  def square(color: String = this.color,
             filled: Boolean = this.filled,
             width: Double = this.width,
             length: Double = this.length,
             side: Double = this.side): Square = new Square(color: String, filled: Boolean, width: Double, length: Double, side: Double)


  def side(s: Double): Square = square(side = s)

  override def width(w: Double): Square = square(width = side)

  override def length(l: Double): Square = square(length = side)

  override def perimeter: Double = Rectangle.calculatePerimeter(side, side)

  override def area: Double = Rectangle.calculateArea(side, side)


  override def color(c: String): Square = square(color = c)

  override def filled(f: Boolean): Square = square(filled = f)

  override def toString = s"Square(color = $color, filled = $filled, side = $side, perimeter = $perimeter,area = $area)"
}

object Square {
  def apply(color: String, filled: Boolean, width: Double, length: Double, side: Double): Square = new Square(color, filled, width, length, side)
}






