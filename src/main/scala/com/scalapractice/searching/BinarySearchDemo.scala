package com.scalapractice.searching

import scala.annotation.tailrec

object BinarySearchDemo {

  def main(args: Array[String]): Unit = {
    val array = Array(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    val input = Array(100,10,50,21,30,15)
   /* println(s"  ${binarySearch(array,56,0,array.length-1)}")
    println(s" recurssive  ${binarySearchTail(array,72,0,array.length-1)}")*/
    println( s"  ---  ${java.util.Arrays.binarySearch(input,21)}  ")
    println( s"  ---  ${java.util.Arrays.binarySearch(array,8)}  ")
  }

  def binarySearch(input:Array[Int], key:Int, low:Int, high:Int) : Int = {
    if( low > high )
      -1
      val mid = low + (high - low) / 2

      if (input(mid) == key) {
       return mid
      }
      else if (input(mid) > key)
        return binarySearch(input, key,low, mid - 1)
        else
        return binarySearch(input, key,mid + 1, high)
  }

  @tailrec
  def binarySearchTail(input:Array[Int], key:Int,low:Int, high:Int): Int =
  {
    if(low > high) return -1
    val mid = low + (high-low)/2

     input(mid) match {
       case i if(i == key) => mid
       case j if(j < key) => binarySearchTail(input,key,mid+1,high)
       case _ => binarySearchTail(input,key,low,mid-1)
        }
  }

}
