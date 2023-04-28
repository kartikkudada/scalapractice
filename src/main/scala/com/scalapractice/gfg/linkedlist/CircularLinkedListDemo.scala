package com.scalapractice.gfg.linkedlist

import scala.annotation.tailrec

object CircularLinkedListDemo {

  def main(args: Array[String]): Unit = {
    val A  = Node(1,null)
    val B  = Node(2,null)
    val C  = Node(3,null)
    val D  = Node(4,null)

    A.next = B
    B.next = C
    C.next = D
    D.next = A

    println(s"is Circular ${isCircular(A)}")
    println(s"is Circular using two pointer ${isCircularUsingPointers(A)}")
  }

  def isCircular(head:Node):Boolean = {
    var temp = head.next
    if(head == null)
     return true

    while(temp != null && temp != head)
          temp = temp.next

    temp == head
  }

  /*
    is linkedlist circular : using two pointer
   */

  def isCircularUsingPointers(head:Node):Boolean = {
        var slow = head
        var fast = head.next

        while(fast != null && fast.next != null )
           {
             if(fast == slow)
                return true
               slow = slow.next
               fast = fast.next.next
           }
      false
    }



}
