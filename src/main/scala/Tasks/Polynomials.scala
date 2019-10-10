package Tasks

object Polynomials extends App {
  var pol = new Polynomial(1.1, 2.2, 3.3, 4.4)
  println(pol)

  println(pol.evaluate(2))
  println(pol.add(new Polynomial(1, 1, 1, 1)))
  println(pol.multiply(new Polynomial(1, 1, 1, 1)))
}

class Polynomial(coefficients: Double*) {

  private val arrCoef = coefficients

  def getDegree: Int = arrCoef.length - 1

  private def getCoef(i: Int): Double = if (i < arrCoef.length) arrCoef(i) else 0

  override def toString: String = {
    var result = new StringBuilder
    var plus = ""
    for (i <- getDegree to 0 by -1) {
      if (getCoef(i) != 0) {
        var cf = getCoef(i)
        result ++= (if (cf > 0) plus else "-")
        plus = " + "
        cf = cf.abs
        if (i == 0)
          result ++= f"$cf%.1f"
        else {
          if (cf != 1)
            result ++= f"$cf%.1f"
          if (i > 1)
            result ++= s"x^$i"
          else
            result ++= s"x"
        }
      }
    }
    result.toString
  }

  def evaluate(x: Double): Double = {
    var result = 0.0
    for (i <- 0 to getDegree) {
      var k = 1.0
      for (j <- 1 to i)
        k *= x
      result += getCoef(i) * k
    }
    result
  }

  def add(another: Polynomial): Polynomial = {
    val deg = getDegree max another.getDegree
    val result = new Array[Double](deg + 1)
    for (i <- 0 to deg) {
      result(i) = getCoef(i) + another.getCoef(i)
    }
    new Polynomial(result: _*)
  }

  def multiply(another: Polynomial): Polynomial = {
    val deg = getDegree + another.getDegree
    val result = new Array[Double](deg + 1)
    for (i <- 0 to deg) {
      var k = 0.0
      for (j <- 0 to i)
        k += getCoef(j) * another.getCoef(i - j)
      result(i) = k
    }
    new Polynomial(result: _*)
  }
}