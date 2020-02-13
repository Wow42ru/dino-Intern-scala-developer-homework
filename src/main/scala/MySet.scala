
// Set реализован на базе бинарного дерева.
// Оба метода реализованы с помощью рекурентных алгоритмов.
//Множество параметризовано типом элементов, которые могут содержаться в множестве
//Сложность добавления элемента в худшем случае O(n), в среднем O(log(n)
//Написаны модульные тесты, проверяющие корректность реализации
sealed trait MySet[+T] {
  def add[B >: T](value: B)(implicit ordering: Ordering[B]): MySet[B]// Метод для добавления элемента в множество.
  // Метод принимает новый элемент множества и возвращает новое множество, содержащее данный элемент.




}

case class Leaf[+T]() extends MySet[T] {
  override def add[B >: T](value: B)(implicit ordering: Ordering[B]): MySet[B] = // создаёт новую ветвь
    Node(value, this, this)


}

case class Node[+T](value: T, left: MySet[T], right: MySet[T])
  extends MySet[T] {
  override def add[B >: T](newValue: B)(implicit ordering: Ordering[B]): MySet[B] = //сравнивает и передаёт значение в левую или правую ветвь

    if (ordering.gt(newValue, value)) copy(right = right.add(newValue))
    else if (ordering.lt(newValue, value)) copy(left = left.add(newValue))
    else this




}

object MySet {
  def create[T]: MySet[T] = Leaf[T]()// создаёт новый обьект

  def toList[T](set: MySet[T], traversal: List[T]): List[T] = {//Метод преобразования множества в список.
    // Результат работы метода - объект типа `scala.List` который содержит все элементы из множества.
    set match {
      case Leaf() => List()
      case Node(value, left, right) => traversal ::: List(value) ::: toList(left, traversal) ::: toList(right, traversal)
    }
  }
}


