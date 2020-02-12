abstract sealed class BinaryTree[+A] {


  def value: Int

  def left: BinaryTree[A]

  def right: BinaryTree[A]

  def size: Int

  def isEmpty: Boolean



  def addElement(element: Int): BinaryTree[A] = {
    if (isEmpty) BinaryTree.make(element)
    else if (element < value) BinaryTree.make(value, left.addElement(element), right)
    else if (element > value) BinaryTree.make(value, left, right.addElement(element))
    else this
  }


}

//todo add toList
case object Leaf extends BinaryTree[Nothing] {
  def value = throw new NoSuchElementException

  def left = throw new NoSuchElementException

  def right = throw new NoSuchElementException

  def size = 0

  def isEmpty = true
}


case class Branch[A](value: Int,
                     left: BinaryTree[A],
                     right: BinaryTree[A],
                     size: Int) extends BinaryTree[A] {
  def isEmpty: Boolean = false
}

object BinaryTree {

  def empty[A]: BinaryTree[A] = Leaf

  def make[A](element: Int, left: BinaryTree[A] = Leaf, right: BinaryTree[A] = Leaf): BinaryTree[A] =
    Branch(element, left, right, left.size + right.size + 1)
}