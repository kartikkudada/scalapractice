package com.scalapractice.gfg.array

import java.util

object SortArrayInWaveForm {

  def main(args: Array[String]): Unit = {
    val array = Array(20, 10, 8, 6, 4, 2)

    SortArrayInWaveForm1(array)
    println(s"wave array ${array.mkString(",")}")
  }

  def SortArrayInWaveForm1(input:Array[Int]):Unit = {
    util.Arrays.sort(input)
    println(s"wave array ${input.mkString(",")}")
    var temp = 0
    for(index <- 0 until input.length-1 by 2)
      {
          temp = input(index)
          input(index) = input(index+1)
          input(index+1) = temp
      }

  }
}
