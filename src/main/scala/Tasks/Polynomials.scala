package Tasks

import scala.collection.mutable.ArrayBuffer

object Polynomials extends App {

  println(new Poly(5.9, 1.5, 2.3, 3.8))

}

class Poly(coeff: Double*) {
  var result: String = ""


  def getDegree: Int = {
    1
  }

  override def toString: String = {

    for (i <- coeff.indices) {
      result = coeff(i) + "x^" + i + "+" + result
    }

    result
  }

  def evaluate(x: Double): Double = {
    x
  }
}

class Monomial(sign:Boolean,c:Double,n:Int){

}