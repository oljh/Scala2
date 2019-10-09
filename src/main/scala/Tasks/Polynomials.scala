package Tasks

object Polynomials extends App {
  var pol = new Polynomial(5.9, 1.5, 2.3, -3.8)
  println(pol)

  println(pol.evaluate(1))
  print(pol.add(new Polynomial(7.0,1.2,3.3,4.6,5.6,6.5,7.5,8.3)))
}

class Polynomial(coefficients: Double*) {

  private val arrCoef = coefficients

  private def createCoeffs(A: Array[Int]): Array[Int] = {
    var s = A.length - 1
    while (s >= 0 && A(s) == 0)
      s -= 1
    A take (s+1)
  }

  def getDegree: Int = arrCoef.length - 1

  def coef(i: Int): Double = if (i < arrCoef.length) arrCoef(i) else 0

  override def toString: String = {
    for (i <- arrCoef.indices) {
      print(arrCoef(i))
    }
    println
    var result = new StringBuilder
    var plus = ""
    for (i <- getDegree to 0 by -1) {
      if (coef(i) != 0) {
        var cf = coef(i)
        result ++= (if (cf > 0) plus else "-")
        plus = "+"
        cf = cf.abs
        if (i == 0)
          result ++= cf.toString
        else {
          if (cf != 1)
            result ++= cf.toString + ""
          if (i > 1)
            result ++= "x^" + i.toString
          else
            result ++= "x"
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
      result += coef(i) * k
    }
    result
  }

  def add(another: Polynomial): Polynomial = {
    val deg = getDegree max another.getDegree
    val result= Array[Double](8)
    for (i <- 1 to 7){ print(result(i) = coef(i) + another.coef(i))}
    new Polynomial(result:_*)
  }

  def multiple(another: Polynomial): Polynomial = {
    if (getDegree < 0)
      this
    else if (another.getDegree < 0)
      another
    else {
      val deg = getDegree + another.getDegree
      val result= Array[Double](deg+1)
      for (i <- 0 to deg) {
        var sum = 0.0
        for (j <- 0 to i)
          sum += coef(j) * another.coef(i - j)
        result(i) = sum
      }
      new Polynomial(result:_*)
    }
  }

}
