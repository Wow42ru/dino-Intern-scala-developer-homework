import scala.annotation.tailrec
import scala.collection.immutable
import scala.collection.mutable.ListBuffer


sealed trait Tree[T] {
  def add(value: T)(implicit ordering: Ordering[T]): Tree[T]

  def walk(f: T => Unit) {}


}

case class Empty[T]() extends Tree[T] {
  override def add(value: T)(implicit ordering: Ordering[T]): Tree[T] =
    Node[T](value, this, this)




}

  case class Node[T](value: T, left: Tree[T], right: Tree[T])
    extends Tree[T] {
    override def add(newValue: T)(implicit ordering: Ordering[T]): Tree[T] =

      if (ordering.gt(newValue, value)) copy(right = right.add(newValue))
      else if (ordering.lt(newValue, value)) copy(left = left.add(newValue))
      else this

    override def walk(f: T => Unit) {
      left.walk(f)
      f(value)
      right.walk(f)
    }





  }
  object Tree {
    def create[T]: Tree[T] = Empty[T]()
    def toList[T](tree: Tree[T], traversal: List[T]): List[T] = {
      tree match {
        case Empty() => List()
        case Node(elem, left, right) => traversal ::: List(elem) ::: toList(left, traversal) ::: toList(right, traversal)
      }
    }
  }


