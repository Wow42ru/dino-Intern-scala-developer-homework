import scala.io.StdIn

object Main {

  def main(args: Array[String]) {
    var tree = Tree.create[Int]

    for (i <- 1 to 10000) {
      val value = scala.util.Random.nextInt(i)
      tree = tree.add(value)
    }

 //   tree.walk(println)
  print(Tree.toList(tree,List.empty))
  }
}