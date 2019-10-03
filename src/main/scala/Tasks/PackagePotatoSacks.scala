package Tasks

object PackagePotatoSacks {

  def main(args: Array[String]): Unit = {

    println(packagePotato(1, 1, 6))
    println(packagePotato(1, 5, 11))
    println(packagePotato(2, 1, 9))

  }

  def packagePotato(big: Int, small: Int, goal: Int): Boolean = {
    if (goal == 0) true
    else if (goal == 0 & (small >= 0 || big >= 0)) true
    else if ((big > 0) & (goal >= big * 5)) packagePotato(big - 1, small, goal - 5)
    else if ((small > 0) & (goal > 0)) packagePotato(big, small - 1, goal - 1)
    else false
  }
}
