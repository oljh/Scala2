package Tasks.ImplementHierarchy

class Circle(color: String, filled: Boolean, radius: Double) extends Shape(color: String, filled: Boolean) {

  def radius(r: Double): Circle = new Circle(color, filled, r)


  override def color(color: String): Circle = new Circle(color, filled, radius)

  override def filled(f: Boolean): Circle = new Circle(color, f, radius)

  override def perimeter: Double = 2 * Math.PI * radius

  override def area: Double = Math.PI * Math.pow(radius, 2)

  override def toString = s"Circle(radius = $radius,color = $color, filled = $filled, perimeter = $perimeter,area = $area)"
}


