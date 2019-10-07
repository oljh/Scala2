package Demo

object modPolOfDegreeN extends App {

  val pt = new Point(10, 20)
  pt.move(10, 10)

  val loc = new Location(10, 20, 30)
  loc.move(16, 34, 10)

}

class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy

  }

  override def toString: String =
    s"($xc, $yc)"

}


class Location(val xc: Int, val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    x = x + dx
    y = y + dy
    z = z + dz

    println("Point x location :" + x)
    println("Point y location :" + y)
    println("Point z location :" + z)
  }
}












