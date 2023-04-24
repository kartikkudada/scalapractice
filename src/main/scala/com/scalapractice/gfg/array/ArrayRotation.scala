package com.scalapractice.gfg.array

object ArrayRotation {

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    val d = 2

    val result = new Array[Int](array.length)
    var pos = 0
    for (index <- d until array.length) {
      result(pos) = array(index)
      pos += 1
    }
    var i = 0
    for (index <- pos until result.length) {
      result(index) = array(i)
      i += 1
    }

    println(s"${result.mkString(",")}")
  }

}
