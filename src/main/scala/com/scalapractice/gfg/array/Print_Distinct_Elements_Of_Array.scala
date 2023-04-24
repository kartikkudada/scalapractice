package com.scalapractice.gfg.array

import scala.collection.mutable
import scala.util.control.Breaks.break

/*
Print All Distinct Elements of a given integer array
 */
object Print_Distinct_Elements_Of_Array {

  def main(args: Array[String]): Unit = {
    val input = Array(12, 10, 9, 45, 2, 10, 10, 45)
    for(i <- 0 until input.length)
      {
        scala.util.control.Breaks.breakable {
        for(j <- i+1 until input.length  )
          {
            if(input(i) == input(j))
              break;
          }
          print(s"${input(i)}  ")
        }
      }

    println("*************")
    printDistinctElements(input)
    printDistinctElements3(input)
  }

  /*
   2nd solution
   */
  def printDistinctElements(input:Array[Int]):Unit= {

    val set = new mutable.TreeSet[Int]()

    for(i <- 0 until input.length)
      {
            set+=input(i)
      }

    println(s"Distinct elements in Arraay using Set ${set.mkString(",")}")
  }

  /*
    3rd solution
   */
  def printDistinctElements3(input:Array[Int]):Unit= {
    val hm = new mutable.HashMap[Int,Int]
    for(i <- 0 until input.length)
      {
         hm += (input(i) -> i)
      }

    println(s"Distinct elements in Arraay using HashMap ${hm.keySet.mkString(",")}")

  }
}
