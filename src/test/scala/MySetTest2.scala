
import org.specs2.mutable.Specification

class MySetTest2 extends Specification {

  "MySet" should {

    "create" in {
      val result = MySet.create
      result === Leaf()
    }

    "to List[Int]" in {
      var set = MySet.create[Int]
      set = set.add(23)
      set = set.add(12)
      set = set.add(212)
      set = set.add(32)
      set = set.add(12)
      set = set.add(12)
      set = set.add(12)

      val result = MySet.toList(set, List.empty)
      result === List(23, 12, 212, 32)
    }
 "to List[String]" in {
      var set = MySet.create[String]
      set = set.add("test")
      set = set.add("12")
      set = set.add("212")
      set = set.add("32")
      set = set.add("12")
      set = set.add("test")
      set = set.add("12")

      val result = MySet.toList(set, List.empty)
      result === List("test", "12", "212", "32")
    }

    "add" in {
      val set = MySet.create[String]
      val result = set.add("test")

      result === Node("test",Leaf(),Leaf())
    }

  }
}

