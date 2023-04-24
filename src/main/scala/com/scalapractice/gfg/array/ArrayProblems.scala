package com.scalapractice.gfg.array

object ArrayProblems {

  def main(args: Array[String]): Unit = {
    val array = Array(1, 3, 2, 2, 5)

    println(s"${rearrangeArray(array).mkString(",")}")
    val input = Array(1, 3, 2, 2, 5)
    println(s"${rearrangeArray2(input).mkString(",")}")
  }

  def rearrangeArray(array: Array[Int]): Array[Int] = {
    java.util.Arrays.sort(array)

    var end = array.length - 1
    var start = 0
    val result = new Array[Int](array.length)
    for (i <- 0 until array.length) {
      (i + 1) % 2 == 0 match {
        case true => result(i) = array(end); end -= 1
        case false => result(i) = array(start); start += 1
      }
    }
    result
  }

  def rearrangeArray2(array: Array[Int]): Array[Int] = {

    var temp = 0
    for (i <- 1 until array.length) {
      i % 2 == 0 match {
        case true => {
          if (array(i) > array(i - 1)) {
            temp = array(i - 1)
            array(i - 1) = array(i)
            array(i) = temp
          }
        }
        case false => {
          if (array(i) < array(i - 1)) {
            temp = array(i - 1)
            array(i - 1) = array(i)
            array(i) = temp
          }
        }
      }
    }

    array
  }


}
