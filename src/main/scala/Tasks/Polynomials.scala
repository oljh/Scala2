package Tasks

object Polynomials extends App {
  var pol = new Polynomial(1.0, 2.0, 3.0, 4.0)
  println(pol)

  println(pol.evaluate(2))
  println(pol.add(new Polynomial(2, 2, 2, 2)))
  println(pol.multiply(new Polynomial(2, 2, 2, 2)))
}

class Polynomial(coefficients: Double*) {

  private val arrCoef = coefficients

  def getDegree: Int = arrCoef.length - 1

  private def getCoef(i: Int): Double = if (i < arrCoef.length) arrCoef(i) else 0

  override def toString: String = {
    val result = new StringBuilder
    for (i <- getDegree to 0 by -1) {
      val cf = getCoef(i)
      val absCF = cf.abs
      val symbol = if (i == getDegree) "" else if (cf > 0) " + " else " - "
      val x = if (i > 1) s"x^$i" else if (i == 1) s"x" else if (i == 0) ""
      val text = if (i == 0 || cf != 1) symbol + f"$absCF%.1f" + x
      result.append(text)
    }
    result.toString
  }

  def evaluate(x: Double): Double = {
    var result = 0.0
    for (i <- 0 to getDegree) {
      val r = math.pow(x, i)
      result += getCoef(i) * r
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

    for (i <- 0 to deg; j <- 0 to i) {
      result(i) += getCoef(j) * another.getCoef(i - j)
    }

    new Polynomial(result: _*)
  }
}