sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object TestTree extends App {
  val l:Leaf[Int] = Leaf[Int](9)
  val b:Branch[Int] = Branch[Int](l,l)

  println(Tree.size(l))
  println(Tree.size(b))


}

object Tree {
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + size(r) + 1
  }

  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(n) => n
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 0
    case Branch(l, r) => depth(l) max depth(r) + 1
  }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(a) => Leaf(f(a))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  /**
    * f - function to apply on data stored in tree
    * g - function to "fold" tree's branches
    */
  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(a) => f(a)
    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  def sizeUsingFold[A](t: Tree[A]): Int =
    fold(t)(v => 1)(1 + _ + _)

  def maximumUsingFold(t: Tree[Int]): Int =
    fold(t)(v => v)(_ max _)

  def depthUsingFold[A](t: Tree[A]): Int =
    fold(t)(v => 0)((d1, d2) => d1 max d2)

  def mapUsingFold[A, B](t: Tree[A])(f: A => B): Tree[B] =
    fold(t)(v => Leaf(f(v)): Tree[B])(Branch(_, _))
}