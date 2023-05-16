package com.scalapractice.sorting

object QuickSortDemo {

  def main(args: Array[String]): Unit = {
    val array = Array(10, 80, 30, 90, 40, 50, 70)

    val size = array.length
    quickSort(array,0,array.length-1)

    println(s" result : ${array.mkString(",")}")
  }
  def swap(input:Array[Int],i:Int,j:Int):Unit = {
    val temp = input(i)
    input(i) = input(j)
    input(j) = temp
  }


  def partition(input:Array[Int],start:Int,end:Int): Int = {
    var i = start +1
    var piv = input(start) // first element as pivot
    for( j <- start +1 until end)
      {
         if(input(j) < piv)
           {
              swap(input,i,j)
             i+=1
           }
      }
      swap(input,i,end-1)     //put the pivot element in its proper place.
      i-1                     //return the position of the pivot
  }

  def quickSort(input:Array[Int],low:Int,high:Int): Unit =
  {
    if(low < high)
      {
          var pivot = partition(input,low,high)
        quickSort(input,low,pivot-1)
        quickSort(input,pivot+1,high)
      }
  }
}
