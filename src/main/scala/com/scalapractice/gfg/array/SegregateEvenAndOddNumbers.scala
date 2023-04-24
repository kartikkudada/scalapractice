package com.scalapractice.gfg.array

object SegregateEvenAndOddNumbers {


  def main(args: Array[String]): Unit = {
    val array = Array(1, 9, 5, 3, 2, 6, 7, 11)
    var temp = 0
    /* for(i <- 0 until array.length)
      {
          if(array(i)%2 != 0)
            {
               for(j <- i+1 until array.length)
                 {
                    if(array(j)%2==0)
                      {
                        //swap
                        temp = array(i)
                        array(i) = array(j)
                        array(j) = temp
                      }
                 }
            }
      }*/

    val result = new Array[Int](array.length)
    var index = 0
    for (i <- 0 until array.length) {
      if (array(i) % 2 == 0) {
        result(index) = array(i)
        index += 1
      }
    }

    for (i <- 0 until array.length) {
      if (array(i) % 2 != 0) {
        result(index) = array(i)
        index += 1
      }
    }

    println(s"${result.mkString(",")}")
  }

}
