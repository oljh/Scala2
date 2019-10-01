package Tasks

import scala.util.matching.Regex

object ReverseOddWord {

  def main(args: Array[String]): Unit = {

    val rex: Regex = "\\w+".r
    val sentence: String = "!awe%sOme&teXt*password!"

    var l: List[String] = (rex findAllIn sentence).toList
    println(l)

    for (k <- 0 until l.size) {
      print(" ")
      if (k % 2 == 0) {
        print(l(k).reverse)
      }
      else print(l(k))
    }

    oRev(sentence)
  }

  def oRev(str: String): Unit = {
    var count: Int = 0
    var boo: Boolean = false
    var result: String = ""
    for (s <- str) {

      if (Character.isAlphabetic(s) & (count % 2) == 0) {
        boo = true
        result = result + s

      } else if (Character.isAlphabetic(s) & (count % 2) != 0) {
        result =  s + result
        boo = true}

      if (!Character.isAlphabetic(s) & boo == true) {
        count = count + 1
        result = result + s
        boo == false

      }
    }
    print(result)
  }


  /*

    def oddRev(str: String): String = {


      def rev(str: String, count: Int, rStr: String, nW: Boolean): String = {

        if (Character.isAlphabetic(str.head) & (count % 2) != 0) {
          rev(str.tail, count, rStr + str.head, true)
        }
        else if (Character.isAlphabetic(str.head) & (count % 2) == 0) {
          rev(str.tail, count, str.head + rStr, true)

        }

        else if (!Character.isAlphabetic(str.head) & nW == true) {
          rev(str.tail, count + 1, rStr + str.head, false)

        }

      }

      rev(str, 0, "", false)
    }
  */

}