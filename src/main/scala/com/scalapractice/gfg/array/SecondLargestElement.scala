package com.scalapractice.gfg.array

import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.collection.{SortedSet, mutable}

object SecondLargestElementInArray {

  def main(args: Array[String]): Unit = {

    val array = Array(12, 35, 1,87,10, 34, 1,12,100,97)
    println(s" second largset element : ${method1(array)}")

    println(s" second largset element (method2) : ${method2(array)}")

    println(s" second largset element (method3) : ${method3(array)}")

    println(s" second largset element (method4) : ${method4(array)}")
  }

  def method1(input:Array[Int]) :Int = {
    val list = input.toList
    val sortedList = list.sorted
    val len = input.length
    println(s"$sortedList")
    sortedList(len-2)
  }

  def method2(input:Array[Int]) : Int = {
   var list = input.toList
   val max = input.max
  val list2 =   list.filter( _ < max)
    list2.max
  }

  def method3(input:Array[Int]) : Int = {
    var first = Integer.MIN_VALUE
    var second = Integer.MIN_VALUE
    input.foreach(x => {
       first = Math.max(x,first)
    })

    input.foreach(x => {
      if(x != first )
       {
          second = Math.max(second,x)
       }
    })
    second
  }

  /*
   with only one iteration
   */
  def method4(input:Array[Int]) : Int = {
    var first = Int.MinValue
    var second = Int.MinValue
    // Array(12, 35, 1,87,10, 34, 1,12,100,97)
    // first   12  35 87 100
    // second  min 12 35 87 97
    input.foreach( x => {
      if(x > first)
        {
          second = first
          first = x
        }

      if(first > x && x > second )
         second = x
    })
  second
  }
}
