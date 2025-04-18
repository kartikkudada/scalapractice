package dsa_for_dataengineers.geeksforgeeks.arrays

object Array_Problems_1 {

  /*
  https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
    Segregate 0s and 1s in an array
    Input :  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
    Output :  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

    Input :  [0, 1, 0]
    Output :  [0, 0, 1]

    Input :  [1, 1]
    Output :  [1, 1]

    Input :  [0]
    Output :  [0]
 */

  def segregate0and1(input:Array[Int]):Array[Int] ={
   var l = 0
   var r = input.length -1
    while(l < r)
      {
             if(input(l) == 0) {
               l+=1
             }else if(input(r) ==1){
              r-=1
             }
             else{
               var temp = input(l)
               input(l) = input(r)
               input(r) = temp
             }
      }
  input
  }

/*
Product of Array Except Self
https://www.geeksforgeeks.org/a-product-array-puzzle/
example :
Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]

 */

  def productExceptSelf(input:Array[Int]): Array[Int] = {
    val product = input.reduce( (x,y) => x*y)
    print(product)
    input.map(product/_)
  }


  /*
  link : https://www.geeksforgeeks.org/find-the-first-missing-number/
  Find the smallest missing number
  Given a sorted array of n distinct integers where
  each integer is in the range from 0 to m-1 and m > n.
   Find the smallest number that is missing from the array.

  Input: {0, 1, 2, 6, 9}, n = 5, m = 10
  Output: 3
   */
  def findFirstMissing(input:Array[Int]):Int = {
 /*   if(input.head != 0 ) 0

    input.find( (x,y) => {
      println(s"$x $y")
      if((y-x) >1 ) x+1
      else  y
    })*/
 0
  }

  def main(args: Array[String]): Unit = {
    //println(segregate0and1(Array(0, 1, 0, 1, 0, 0, 1, 1, 1, 0)).mkString("[",",","]"))
    //println(productExceptSelf(Array(10, 3, 5, 6, 2)).mkString("[",",","]"))

    println(findFirstMissing(Array(0, 1, 2, 6, 9)))
  }
}
