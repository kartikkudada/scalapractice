package dsa_for_dataengineers

object FindRepeating {

  def findRepeating(arr: Array[Int]): Unit = {
    val seen = scala.collection.mutable.Set[Int]()
    val repeating = Array(0,0)//scala.collection.mutable.ListBuffer[Int]()
    var index = 0
    for (num <- arr) {
      if (seen.contains(num)) {
        repeating(index) = num
        index +=1
      } else {
        seen += num
      }
    }

    println(s"Repeating elements: ${repeating.mkString(" ")}")
  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(4, 2, 4, 5, 2, 3, 1)
    findRepeating(arr1)
  }

}
