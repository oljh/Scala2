package Tasks

object PackagePotatoSacks {

  def main(args: Array[String]): Unit = {

    println(packagePotato(1,1,6))
    println(packagePotato(1,5,11))
    println(packagePotato(2,1,9))

  }

  def packagePotato(big:Int,small:Int,goal:Int): Boolean ={

    val big_mass:Int = big*5
    val small_mass:Int = small

    if ((big_mass+small_mass)<=goal)true else false
  }

}
