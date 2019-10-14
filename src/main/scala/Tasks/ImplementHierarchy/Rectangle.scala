package Tasks.ImplementHierarchy

class Rectangle(color: String, filled: Boolean, width: Double, length: Double) extends Shape(color: String, filled: Boolean) {

  def width(w: Double): Rectangle = new Rectangle(color, filled, w, length)

  def length(l: Double): Rectangle = new Rectangle(color, filled, width, l)


  override def perimeter: Double = 2*width+2*length

  override def area: Double = width*length


  override def color(c: String): Rectangle = new Rectangle(c, filled, width, length )

  override def filled(f: Boolean): Rectangle = new Rectangle(color, f, width, length )


  override def toString = s"Rectangle(width = $width, length = $length, color = $color, filled = $filled, perimeter = $perimeter,area = $area)"
}
