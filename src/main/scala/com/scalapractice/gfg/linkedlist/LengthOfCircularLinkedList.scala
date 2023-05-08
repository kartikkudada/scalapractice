package com.scalapractice.gfg.linkedlist

/*
Count nodes in Circular linked list
Given a circular linked list, count the number of nodes in it.
For example, the output is 5 for the below list.

1 ->  2 ->  3 ->  4 ->  5 ---|
^                            |
|----------------------------v

 */
object LengthOfCircularLinkedList {

  def main(args: Array[String]): Unit = {
    val A = new Node(1, null)
    val B = new Node(2, null)
    val C = new Node(3, null)
    val D = new Node(4, null)
    val E = new Node(5, null)

    A.next = B
    B.next = C
    C.next = D
    D.next = E
    E.next = A

    lenOfCircularList(A)
  }

  def lenOfCircularList(head:Node):Unit = {
      var temp = head
      var count = 0

       do{
          count+=1
          temp = temp.next
        }while(temp != head)
        println(s"length of linkedlist is :  $count")
  }
}
