package com.scalapractice.searching

import scala.annotation.tailrec

/*
Linear Search Algorithm
 */
object LinearSearchDemo {

  val array = Array(10, 50, 30, 70, 80, 20, 90, 4)

  def main(args: Array[String]): Unit = {
    println( s" searching 20 in array :  ${linearSearch1(array,20)}")

    println( s" searching 4 in array, Found in position:  ${linearSearch2(array,4)}")

    println( s" searching 70 in array recursive way, Found in position:  ${linearSearchrecussive(array,0,4)}")
  }

  def linearSearch1(input:Array[Int],data:Int):Boolean = {
    !input.filter(_ == data ).isEmpty
  }

  def linearSearch2(input:Array[Int],data:Int):Int = {
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
  def linearSearchrecussive(input:Array[Int],index:Int,data:Int) :Int = {

    if(index == input.length-1 && input(index) != data)
      -1
    else if( input(index) == data ){
      index
    }
    else {
        linearSearchrecussive(input,index+1,data)
     }
  }
}