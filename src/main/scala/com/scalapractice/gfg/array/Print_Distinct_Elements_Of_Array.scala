package com.scalapractice.gfg.array

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
  }

  def printDistinctElements(input:Array[Int]):Unit= {


  }
}
