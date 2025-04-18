package dsa_for_dataengineers.geeksforgeeks.arrays

import scala.collection.mutable

object Runner {


  def main(args: Array[String]): Unit = {
    println("I am runner")
    //println(s"1. check two sum : ${prob_sum_with_given_sum(Array(0,-1,2,-3,1),-1) }" )
    //println(s"2. check two sum : ${prob_sum_with_given_sum(Array(1, -2, 1, 0, 5),0) }" )

    // Remove duplicates from a string
    println(prob_duplicate_remover("Happy new year"))

    // Remove characters from the first string which are present in the second string
    // Remove characters from the first string which are present in the second string

    /*println(s"after removing c a t ${removeDirtyChars("computer","cat")}")
    println( s" after removing c a r ${removeDirtyChars("occurrence","car") }")
    println(s"another way to remove c a t  ${removeDirtyChars_way2("computer","cat") }")
    println(s"another way to remove c a r  ${removeDirtyChars_way2("occurrence","car") }")*/


    println(s"majority element : ${majorityElement(Array(1, 1, 2, 1, 3, 5, 1))}")
  }


  /*
  https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/
  Two Sum – Pair with given Sum

  Given an array arr[] of n integers and a target value, the task is to find whether there is a pair of elements in the array whose sum is equal to target. This problem is a variation of 2Sum problem.

Examples:
  Input: arr[] = [0, -1, 2, -3, 1], target = -2
  Output: true
  Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.

  Input: arr[] = [1, -2, 1, 0, 5], target = 0
  Output: false
  Explanation: There is no pair with sum equals to given target.
  */

  def prob_sum_with_given_sum(array:Array[Int],target :Int) : Boolean = {
    val sortedArray = array.sortWith( (i:Int,j:Int) => i.compareTo(j) < 0)
    var left = 0
    var right = sortedArray.length -1

    while(left < right)
         {
           (sortedArray(left) + sortedArray(right))  match {
             case `target` => return true
             case sum if (sum > `target`) =>  right= right -1
             case sum if (sum < `target`) =>  left = left +1
           }
         }

    false
  }
 /*
 https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
   Remove duplicates from a string
   input: s = geeksforgeeks
  Output: geksfor
  Explanation: After removing duplicate characters such as e, k, g, s, we have string as “geksfor”.

 Input: s = HappyNewYear
 Output: HapyNewYr
 Explanation: After removing duplicate characters such as p, e, a, we have string as “HapyNewYr”.

  */

  def prob_duplicate_remover(input:String):String = {
    val already_present = new mutable.HashSet[Char]()
     val result = new StringBuilder()
     input.toLowerCase.foreach( e => {
        if(!already_present.contains(e)) {
          already_present+=e ;result+=e
       }
     })

    result.toString()
  }

  /*
  https://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/
  Example :
  Input:
  string1 = “computer”
  string2 = “cat”
  Output: “ompuer”
  Explanation: After removing characters(c, a, t)
  from string1 we get “ompuer”.

  Input:
  string1 = “occurrence”
  string2 = “car”
  Output: “ouene”
  Explanation: After removing characters
  (c, a, r) from string1 we get “ouene”.
   */

  def removeDirtyChars(input:String,mask_str:String): String = {
    var output:StringBuilder = new StringBuilder(input)
    mask_str.foreach(x => {
      if(input.contains(x))
         output =output.filter(_!=x)
      })
    output.toString()
  }

  def removeDirtyChars_way2(input:String,mask_str:String) : String = {
     val array = new Array[Int](26)

     mask_str.foreach(x => {
         //val x_int :Int  = x
         array(x -'a') = -1
     } )
    println(s"visualizing array : ${array.mkString(",")}")
    val result = new StringBuilder()
    input.foreach( x => {
      if(array(x - 'a') != -1)
        {
           result.append(x)
        }
    } )
    result.mkString
  }

/*
 https://www.geeksforgeeks.org/majority-element/
Find the majority element in the array.
If no majority exists, return -1. A majority element in an array is an element that appears strictly more than arr.size() / 2 times in the array

Input : arr[] = {1, 1, 2, 1, 3, 5, 1}
Output : 1
Explanation: Note that 1 appear 4 times which is more than  7 / 2 times

Input : arr[] = {3, 3, 4, 2, 4, 4, 2, 4}
Output :  -1
Explanation: There is no element whose frequency is greater than the half of the size of the array size.

Input : arr[] = {3}
Output : 3
Explanation: Appears more than n/2 times
 */

  def majorityElement(array:Array[Int]) :Int = {
    val frequency_map = new mutable.HashMap[Int,Int]()
     array.foreach(x => {
       frequency_map.contains(x) match {
         case true => val count = frequency_map(x); frequency_map.put(x,count+1);
         case false => frequency_map.put(x,1)
       }
     })

    val seq = frequency_map.toSeq
    val result = seq.sortBy(-_._2).head

    println(array.mkString(","))
    println(seq.mkString(","))
    println(result)
    if(result._2 > array.length/2)
      result._1
    else
      -1
  }

}
