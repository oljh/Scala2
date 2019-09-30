package Tasks

import scala.util.matching.Regex

object ReverseOddWord {

  def main(args: Array[String]): Unit = {


    val rex: Regex = "\\w+".r

    val rtext: String = "!awe%some&text*password!"

    var l: List[String] = (rex findAllIn rtext).toList
    println(l)

    for (k <- 0 to l.size - 1) {
      print(" ")
      if (k % 2 != 0) {
        print(l(k).reverse)
      }
      else print(l(k))
    }


  }


}
