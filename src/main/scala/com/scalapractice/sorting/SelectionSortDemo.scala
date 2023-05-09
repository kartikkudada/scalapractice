package com.scalapractice.sorting

/*
Selection Sort Algorithm
arr[] = {64, 25, 12, 22, 11}
result
arr[] = {11, 12, 22, 25, 64}
 */
object SelectionSortDemo {

  def main(args: Array[String]): Unit = {

    val array = Array(64, 25, 12, 22, 11)
    println(s" Before  Sorting ${array.toList}")

    selectionSort_ASC(array)

    println(s" After Sorting ${array.toList}")

    val array2 = Array(64, 25, 12, 22, 11)

    println(s" Before Sorting desc ${array2.toList}")

    selectionSort_Desc(array2)

    println(s" After Sorting desc ${array2.toList}")
  }

  def swap(array:Array[Int],i:Int,j:Int) :Unit = {
      var temp = array(i)
      array(i) = array(j)
      array(j) = temp
  }

  def selectionSort_ASC(array:Array[Int]): Unit = {
    var min_idx = Int.MinValue
    var j = 0
    for (i <- 0 until array.length - 1) {
      min_idx = i
      for (j <- i + 1 until array.length) {
        if (array(j) < array(min_idx))
          min_idx = j
      }
      swap(array, i, min_idx)
    }
  }


  def selectionSort_Desc(array: Array[Int]): Unit = {
    var min_idx = Int.MinValue
    var j = 0
    for (i <- 0 until array.length - 1) {
      min_idx = i
      for (j <- i + 1 until array.length) {
        if (array(j) > array(min_idx))
          min_idx = j
      }
      swap(array, i, min_idx)
    }
  }
}
