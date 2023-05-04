package com.scalapractice.gfg.array

import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.collection.{SortedSet, mutable}

object SecondLargestElementInArray {

  def main(args: Array[String]): Unit = {

    val array = Array(12, 35, 1, 10, 34, 1)
    println(s" second largset element : ${method1(array)}")
  }

  def method1(input:Array[Int]) :Int = {
    val list = input.toList
    val sortedList = list.sorted
    val len = input.length
    println(s"$sortedList")
    sortedList(len-2)
  }
}
