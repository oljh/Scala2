package Tasks

import scala.util.matching.Regex

object ReverseOddWords {

  def main(args: Array[String]): Unit = {
    var sentence: String = "!awe%sOme&teXt*password!simple^sOme"
    var sentence2: String = "just some simple sentence"
    println(sentence)
    println(revOddWord(sentence))
    println(sentence2)
    println(revOddWord(sentence2))
  }

  def revOddWord(str: String): String = {
    val rex: Regex = "\\w+".r
    var list: List[String] = (rex findAllIn str).toList
    var sentence = str
    for (i <- 0 until list.size) {
      if ((i & 1) == 0) {
        sentence = sentence.replaceFirst(list(i), list(i).reverse)
      }
    }
    sentence
  }

}