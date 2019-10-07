package Tasks

object Polynomials extends App {

 println(new Polynomial(5.9,1.5,2.3,3.8))

}

class Polynomial(coef: Double*) {


  def getDegree: Int = {
    1
  }

  override def toString: String = {
var i:Int= coef.size
  coef.reverse.foreach(f => printf(f +"x^%d ",1))
""
  }

  def evaluate(x: Double): Double = {
    x
  }

  def add(another: Polynomial) = {

  }
}