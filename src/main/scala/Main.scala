import scala.io.StdIn

object Main {

  def main(args: Array[String]) {
    var set = MySet.create[String]

    for (i <- 1 to 100) {
      val value = scala.util.Random.nextInt(i)
      set = set.add(value.toString+"d")
    }

 //   tree.walk(println)
  print(MySet.toList(set,List.empty))
  }
}