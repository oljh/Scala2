package Tasks

import scala.util.matching.Regex

object ReverseOddWord {

  def main(args: Array[String]): Unit = {


    val rex: Regex = "\\w+".r

    val rtext: String = "!awe%some&text*password!"

    var l: List[String] = (rex findAllIn rtext).toList
    println(l)


    l.foreach(f => for (k <- 0 to f.size){ if (k%2!=0){print(f.reverse)}})


    }




}
