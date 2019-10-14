package Tasks.ImplementHierarchy

abstract class Shape(color: String, filled: Boolean) extends GeometricObject {

  def perimeter: Double

  def area: Double

  def color(c: String): Shape

  def filled(f: Boolean): Shape
}

