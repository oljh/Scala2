package Tasks

object PascalsTriangle {
  var a: Int = 0
  val max: Int = 20

  def main(args: Array[String]) {
    print("Enter the size of the triangle(max " + max + "): ")
    do {
      a = scala.io.StdIn.readInt()
      if (a > max || a < 0) {
        print("Error value! Please enter from 1 to " + max + ": ")
      }
    } while (a > max || a < 0)
    println("The value of 'size' is " + a)
    drawTriangle(a)

  }

  def drawTriangle(size: Int) {
    var lineSpace: Int = size+2
    for (row <- 0 to size) {
      for (ls <- 0 to lineSpace) print(" ")
      lineSpace = lineSpace - 1
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()

    }

    def pascal(col: Int, row: Int): Int = {
      if (col == 0 || col == row) 1
      else pascal(col - 1, row - 1) + pascal(col, row - 1)
    }

  }
}
