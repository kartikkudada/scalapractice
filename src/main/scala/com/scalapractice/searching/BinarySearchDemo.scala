package com.scalapractice.searching

import scala.annotation.tailrec

object BinarySearchDemo {

  def main(args: Array[String]): Unit = {
    val array = Array(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    println(s"  ${binarySearch(array,911,0,array.length-1)}")
  }
  def binarySearch(input:Array[Int], key:Int, low:Int, high:Int) : Int = {
    if(high >= low) {
      val mid = low + (high - low) / 2
      if (input(mid) == key) {
        return  mid
      }
      else if (input(mid) > key)
        return  binarySearch(input,key,low,mid-1)
      else (input(mid) < key)
        return  binarySearch(input,key,mid+1,high)
    }
    -1
  }

}
