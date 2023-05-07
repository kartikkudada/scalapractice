package com.scalapractice.misc



object RemoveConsecutiveDuplicates {

  /*
  in = "aaabbccddefgaabb"
  out = "abcdefgab"
   */
  def main(args: Array[String]): Unit = {
    val in = "aaabbccddefgaabb"

     val array = in.toCharArray
    val sb = new StringBuilder("")
    var j = 0
    var i = 0
     while(j < array.length)
       {
          if(array(i) != array(j) || j == array.length - 1) {
            sb += array(i)
            i = j
            j+=1
          }
          else {
            j += 1
          }
       }
       println(s"Before : $in")
       println(s"After removal of consecutive duplicates :  ${sb}")
  }
}
