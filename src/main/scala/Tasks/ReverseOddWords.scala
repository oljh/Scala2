package Tasks

object ReverseOddWords {

  def main(args: Array[String]): Unit = {
    val sentence: String = "just some simple sentence"
    println(sentence)
    println(revOddWord(sentence))
  }

  def revOddWord(str: String): String = {
    val list = str.split("\\W+").toList
    var sentence = str
    for (i <- list.indices) {
      if (i % 2 == 0) sentence = sentence.replaceFirst(list(i), list(i).reverse)
    }
    sentence
  }
}