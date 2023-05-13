package com.scalapractice.searching

import scala.annotation.tailrec

/*
Linear Search Algorithm
 */
object LinearSearchDemo {

  val array = Array(10, 50, 30, 70, 80, 20, 90, 4)

  def main(args: Array[String]): Unit = {

    println( s" searching 4 in array, Found in position:  ${linearSearch(array,4)}")

    println( s" searching 200 in array recursive way, Found in position:  ${linearSearchTailrecussive(array,0,200)}")

    println( s" searching 70 in array recursive way, Found in position:  ${linearSearchTailrecussive(array,0,70)}")

  }
  def linearSearch(input:Array[Int],data:Int):Int = {
    for(index <- 0 until input.length)
      {
        input(index) == data match {
          case true => return index
          case _ =>
        }
      }
       -1
  }

  @tailrec
  def linearSearchTailrecussive(input:Array[Int],index:Int,data:Int) :Int = {

    if(index == input.length-1 && input(index) != data)
      -1
    else if( input(index) == data ){
      index
    }
    else {
      linearSearchTailrecussive(input,index+1,data)
     }
  }


  def linearSearchRecussive(input: Array[Int], index: Int, data: Int): Int = {
    if (input(index) == data)
       index
    else if(index < input.length)
      linearSearchRecussive(input, index + 1, data)
   else (index == input.length - 1 && input(index) != data)
      -1
  }


}
