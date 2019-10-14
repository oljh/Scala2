package Tasks.ImplementHierarchy

class Square(color: String, filled: Boolean, width: Double, length: Double, side: Double) extends Rectangle(color: String, filled: Boolean, width: Double, length: Double) {

  def side(s: Double): Square = new Square(color, filled, side, side,s)

  override def length(l: Double): Square = new Square(color, filled, side, side,side)

  override def perimeter: Double = side * 4

  override def area: Double = Math.pow(side, 2)


  override def color(c: String): Square = new Square(c, filled, width, length,side)

  override def filled(f: Boolean): Square = new Square(color, f, width, length,side)

  override def toString = s"Square(side = $side,color = $color, filled = $filled, perimeter = $perimeter,area = $area)"
}

