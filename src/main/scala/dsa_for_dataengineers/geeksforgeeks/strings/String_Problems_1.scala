package dsa_for_dataengineers.geeksforgeeks.strings

object String_Problems_1 {

  def main(args: Array[String]): Unit = {

    println(areRotations("abcd","cdab"))
  }

  /*
  https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/

  Input: s1 = “abcd”, s2 = “cdab”
  Output: true
  Explanation: After 2 right rotations, s1 will become equal to s2.

  Input: s1 = “aab”, s2 = “aba”
  Output: true
  Explanation: After 1 left rotation, s1 will become equal to s2.
  */

  def areRotations(string1:String,string2:String):Boolean ={
    string1.sortWith( (x,y) => x<y ).equals(string2.sortWith((x,y) => x<y))

  }
}
