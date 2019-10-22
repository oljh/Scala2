package Tasks

object TestFunSets extends App {

  import FunSets._

  val funSet1 = Set(7, 9, 3, 8, 2, 1, 6, 7)
  val funSet2 = Set(6, 2, 5, 8, 4)
  println(contains(funSet1, 4))
  printSet(singletonSet(4))
  printSet(union(funSet1, funSet2))
  printSet(intersect(funSet1, funSet2))
  printSet(diff(funSet1, funSet2))
  printSet(filter(funSet1, p = _ > 5))
  println(forall(funSet1, n => n < 2))
  println(exists(funSet1, k => 10 > k && k > 8))
  printSet(map(funSet1, f = _ + 5))


}

object FunSets {
  /**
    * We represent a set by its characteristic function, i.e.
    * its `contains` predicate.
    */
  type Set = Int => Boolean

  /**
    * Indicates whether a set contains a given element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Returns the set of the one given element.
    */
  def singletonSet(elem: Int): Set = (n: Int) => n == elem

  /**
    * Returns the union of the two given sets,
    * the sets of all elements that are in either `s` or `t`.
    */
  def union(s: Set, t: Set): Set = (n: Int) => s(n) || t(n)

  /**
    * Returns the intersection of the two given sets,
    * the set of all elements that are both in `s` and `t`.
    */
  def intersect(s: Set, t: Set): Set = (n: Int) => s(n) && t(n)

  /**
    * Returns the difference of the two given sets,
    * the set of all elements of `s` that are not in `t`.
    */
  def diff(s: Set, t: Set): Set = (n: Int) => s(n) && !t(n)

  /**
    * Returns the subset of `s` for which `p` holds.
    */
  def filter(s: Set, p: Int => Boolean): Set = (n: Int) => s(n) && p(n)

  /**
    * The bounds for `forall` and `exists` are +/- 1000.
    */

  val bound = 1000

  /**
    * Returns whether all bounded integers within `s` satisfy `p`.
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }

    iter(-bound)
  }

  /**
    * Returns whether there exists a bounded integer within `s`
    * that satisfies `p`.
    */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, n => !p(n))

  /**
    * Returns a set transformed by applying `f` to each element of `s`.
    */
  def map(s: Set, f: Int => Int): Set = (k: Int) => exists(s, n => f(n) == k)

  /**
    * Displays the contents of a set
    */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
    * Prints the contents of a set on the console.
    */
  def printSet(s: Set) {
    println(toString(s))
  }
}