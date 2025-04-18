package dsa_for_dataengineers.geeksforgeeks.arrays

object GeeksForGeeks_Problems {

  def main(args: Array[String]): Unit = {
    println("Hello world")
    twoRepeated(Array(4, 2, 4, 5, 2, 3, 1))
  }

  /*
  Find the two repeating elements in a given array
  Input: arr = [4, 2, 4, 5, 2, 3, 1], N = 5
  Output: 4 2

  Input: arr = [2, 1, 2, 1, 3], N = 3
  Output: 1 2
  https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
   */

  def twoRepeated(arr:Array[Int]) :Unit = {

    val seen = scala.collection.mutable.Set[Int]()
    val repeating = scala.collection.mutable.ListBuffer[Int]()

    arr.map { num =>
      if (seen.contains(num)) {
        repeating += num
      } else {
        seen += num
      }
    }


    println(seen)
    println("Hello world")
  }
}
