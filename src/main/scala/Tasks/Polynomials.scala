package Tasks

object Polynomials extends App {

  println(new Poly(5.9, 1.5, 2.3, -3.8))

}

class Poly(coef: Double*) {

  private val ArCof = crCoeffs(coef.toArray)


  private def crCoeffs(arrCof: Array[Double]): Array[Double] = {
    var s = arrCof.length - 1
    while (s >= 0 && arrCof(s) == 0)
      s -= 1
    arrCof take (s + 1)
  }

  def degree: Int = ArCof.length - 1

  def coeff(i: Int): Double = if (i < ArCof.length) ArCof(i) else 0

  override def toString: String = {
    for (i <- ArCof.indices) {
      print(ArCof(i))
    }
    println

    var s = new StringBuilder
    var plus = ""
    for (i <- degree to 0 by -1) {
      if (coeff(i) != 0) {
        var c = coeff(i)
        s ++= (if (c > 0) plus else "-")
        plus = "+"
        c = c.abs
        if (i == 0)
          s ++= c.toString
        else {
          if (c != 1)
            s ++= c.toString + ""
          if (i > 1)
            s ++= "x^" + i.toString
          else
            s ++= "x"
        }
      }
    }
    s.toString
  }

  // evaluate this polynomial at x
  def evaluate(x: Double): Double = {
    var result = 0.0
    for (i <- 0 to degree) {
      var power = 1.0
      for (j <- 1 to i)
        power *= x
      result += coeff(i) * power
    }
    result
  }
}
