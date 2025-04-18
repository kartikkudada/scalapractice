package dsa_for_dataengineers.geeksforgeeks.arrays

object Array_Problems {

  def main(args: Array[String]): Unit = {

    println("get Odd occurance number in Array")
    println(getOddOccurance(Array(1, 2, 3, 2, 3, 1, 3)))
    println(getOddOccurance(Array(5, 7, 2, 7, 5, 2, 5)))

    println("get Odd occurance number in Array with XOR")
    println(getOddOccurance_wthXOR(Array(5, 7, 2, 7, 5, 2, 5)))

    println("merging sorted array")
    println("mplusN Array : 2, 8, -1, -1, -1, 13, -1, 15, 20 And N Array :5, 7, 9, 25")
    println(mergeSortedArray(Array(2, 8, -1, -1, -1, 13, -1, 15, 20),Array(5, 7, 9, 25)).mkString(","))

    println("Left rotate Array")
    println(s"Input Array [1, 2, 3, 4, 5, 6, 7] and place = 2 ==> " +
      s"${leftRotateArray(Array(1,2,3,4,5,6,7),2).mkString("[",",","]")}")

    //Better way to rotate
   println(s"Left rotate Array 1,2,3,4,5 and place : 2 ${leftRotateArray_1(Array(1,2,3,4,5),2).mkString("[",",","]")}")

   // find leaders
   println(s" find leader in Array(16, 17, 4, 3, 5, 2):  ${find_leader(Array(16, 17, 4, 3, 5, 2)).mkString("[",",","]")}")
   println(s" find leader in Array(1, 2, 3, 4, 5, 2):  ${find_leader(Array(1, 2, 3, 4, 5, 2)).mkString("[",",","]")}")

    find_majority(Array(1, 2, 3, 3, 3, 3, 10))

    twoRepeated(Array(4, 2, 4, 5, 2, 3, 1))
  }

/*
 Majority Element
 https://www.geeksforgeeks.org/majority-element/

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

  // By sorting array
  def majorityElement(array:Array[Int]):Unit = {
    array.sortWith( (x,y) => x<y)

  }


  /*
  Given an array of positive integers. All numbers occur an even number of times except one number
  which occurs an odd number of times. Find the number in O(n) time & constant space.
Examples :
Input : arr = {1, 2, 3, 2, 3, 1, 3}
Output : 3
Input : arr = {5, 7, 2, 7, 5, 2, 5}
Output : 5

Link : https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
*/

  def getOddOccurance(input:Array[Int]) : Int = {
    val map = new scala.collection.mutable.HashMap[Int,Int]()

   input.foreach(x => {
      if(map.contains(x)) {
        val value = map.get(x).get
        map+=(x->(value+1))
      }
      else
            map+=(x->1)
    })

   map.toList.filter(x => { x._2%2 == 1}).head._1
  }

  /*
  x^0 = x
  x^y=y^x (Commutative property holds)
  (x^y)^z = x^(y^z) (Distributive property holds)
  x^x=0
   */
  def getOddOccurance_wthXOR(input:Array[Int]) : Int = {
   input.foldLeft(0) ( (x,y) => {
            val res = x ^ y
            //println(res)
             res
    } )
  }

  /*
  link : https://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
  There are two sorted arrays.
   First one is of size m+n containing only m elements.
   Another one is of size n and contains n elements.
   Merge these two arrays into the first array of size m+n such that the output is sorted.

   example
   m+n array :  [2, 8, -1, -1, -1, 13, -1, 15, 20]
   n array : [ 5, 7, 9, 25 ]
   output : [2 5 7 8 9 13 15 20 25 ]
   */

  def mergeSortedArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    // Shift valid elements to the left in arr1
    var index = 0
    val m = arr1.count(_ != -1)
    val n = arr2.length
    for (i <- arr1.indices if arr1(i) != -1) {
      arr1(index) = arr1(i)
      index += 1
    }

    var i = m - 1 // Last index of valid elements in arr1
    var j = n - 1 // Last index of arr2
    var k = arr1.length - 1 // Last index of arr1 (full size)

    // Merge in reverse order
    while (i >= 0 && j >= 0) {
      if (arr1(i) > arr2(j)) {
        arr1(k) = arr1(i)
        i -= 1
      } else {
        arr1(k) = arr2(j)
        j -= 1
      }
      k -= 1
    }
    arr1
  }

  /*
  https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/

  Reversal algorithm for Array rotation
  Input:  arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
Output: 3, 4, 5, 6, 7, 1, 2
Explanation: If the array is rotated by 1 position to the left,
it becomes {2, 3, 4, 5, 6, 7, 1}.
When it is rotated further by 1 position,
it becomes: {3, 4, 5, 6, 7, 1, 2}
 */

def leftRotateArray(array:Array[Int],place:Int):Array[Int] = {
 var temp = array(0)
  val last = array.length -1
  for(i <- 1 to place)
    {
        temp = array(i-1)
       for(j <- 1 until array.length)
         {
            array(j-1) = array(j)
         }
         array(last) = temp
    }

  array
}
  //efficient one
  //Better way to rotate
def leftRotateArray_1(input:Array[Int],place:Int):Array[Int] = {

  val subArray_1 = input.take(place).reverse
  val subArray_2 = input.drop(place).reverse

  (subArray_1 ++ subArray_2).reverse
}

   /*
   find leaders
   https://www.geeksforgeeks.org/leaders-in-an-array/

   Example :
   Input: arr[] = [16, 17, 4, 3, 5, 2]
   Output: [17 5 2]

   Input: arr[] = [1, 2, 3, 4, 5, 2]
   Output: [5 2]
   */
  def find_leader(input:Array[Int]):Array[Int] = {
      val list = List(input.last)
     input.foldRight(list)( (x,acc) => {
        if(x > acc.head)
             x::acc
        else
             acc
      } ).toArray
  }

  def find_majority(input:Array[Int]) : Unit = {
  val map =  input.foldLeft(Map.empty[Int,Int]) ( (acc,x) => {
      if(acc.contains(x)) {
         val cnt = acc.get(x).get
         acc + (x -> (cnt+1))
      }
      else
        acc + (x -> 1)
    })

    print(map)

  }

  /*
  link : https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
  Input: arr = [4, 2, 4, 5, 2, 3, 1], N = 5
Output: 4 2

Input: arr = [2, 1, 2, 1, 3], N = 3
Output: 1 2
   */

  def twoRepeated(arr:Array[Int]):Unit = {

    val seen = scala.collection.mutable.Set[Int]()
    val repeating = new scala.collection.mutable.ListBuffer[Int]()

 /*   for(num <- arr)
      {
        if(seen.contains(num))
          {
            repeating += num
          }
        else
          {
            seen += num
          }
      }*/

    println(repeating)
  }

}
