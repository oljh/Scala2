package Tasks

object ParenthesesBalancing {
  def main(args: Array[String]): Unit = {

    val s1: String = "(if (zero? x) max (/ 1 x))"
    val s2: String = "I told him (that it’s not (yet) done). (But he wasn’t listening)"
    val s3: String = ":-)"
    val s4: String = "())("
    var text = List(s1, s2, s3, s4)

    text.foreach(f => println(f+"  --->  "+  balance(f.toList)))


    def balance(chars: List[Char]): Boolean = {

      def counter(ch: List[Char], nc: Int): Boolean = {
        if (ch.isEmpty) nc == 0
        else if (nc < 0) false
        else if (ch.head == '(') counter(ch.tail, nc + 1)
        else if (ch.head == ')') counter(ch.tail, nc - 1)
        else counter(ch.tail, nc)

      }
      counter(chars, 0)
    }
  }
}

