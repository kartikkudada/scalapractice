package com.scalapractice.gfg.array

object Largest3DistinctNumbers {

  def main(args: Array[String]): Unit = {
    val array = Array[Int](10, 4, 3, 50, 23, 90)

    var first, second, third = Integer.MIN_VALUE

    println(s"$first $second $third")

    array.foreach(x => {
      if (x > first) {
        third = second
        second = first
        first = x
      }
      else if (x > second && x != first) {
        third = second
        second = x

      }
      else if (x > third && x != second) {
        third = x
      }
    })

    println(s"$first $second $third")

    println(s"move all zeros to end ${moveAllZerosAtEnd(Array[Int](5, 6, 0, 4, 6, 0, 9, 0, 8)).mkString(",")}")
  }

  def moveAllZerosAtEnd(input: Array[Int]): Array[Int] = {
    // val input = Array[Int](5, 6,0,4,6,0,9,0,8)

    var index = 0
    var temp = 0
    for (i <- 0 until input.length) {
      if (input(i) != 0) {
        //swap
        temp = input(i)
        input(i) = input(index)
        input(index) = temp
        index += 1
      }
    }
    input
  }
}
