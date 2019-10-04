package Tasks

object PackagePotatoSacks {

  def main(args: Array[String]): Unit = {

    println(packagePotato2(1, 1, 6))
    println(packagePotato2(1, 5, 11))
    println(packagePotato2(2, 1, 9))

  }

  def packagePotato(big: Int, small: Int, goal: Int): Boolean = {
    if ((big >= 0) && (small >= 0) && (goal == 0)) true
    else if ((big > 0) && (goal > 5)) packagePotato(big - 1, small, goal - 5)
    else if ((small > 0) && (goal > 0)) packagePotato(big, small - 1, goal - 1)
    else false
  }
/*
  Try not to use recursion, the end solution should be one-lined if-else statement with some math:

  if (big * 5 >= ...) ... >= ... % 5 else ... >= goal - ... * ...

*/
  def packagePotato2(big: Int, small: Int, goal: Int): Boolean = {
    if (big * 5 >= goal) big >= goal % 5 else if (small >= goal) small >= goal % 1 else false
}

}
