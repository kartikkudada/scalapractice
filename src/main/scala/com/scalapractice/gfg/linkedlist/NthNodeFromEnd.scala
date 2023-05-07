package com.scalapractice.gfg.linkedlist

/*
Program for Nth node from the end of a Linked List

Given a Linked List and a number N, write a function that
 returns the value at the Nth node from the end of the Linked List.
 */
object NthNodeFromEnd {

  def main(args: Array[String]): Unit = {
    val one = Node(1, null)
    val two = Node(2, null)
    val three = Node(3, null)
    val four = Node(4, null)
    val five = Node(5, null)

    one.next = two
    two.next = three
    three.next = four
    four.next = five

    LinkedListDemo.traverse(one)
    findNthNodeFromEnd(one,2)
  }

  def findNthNodeFromEnd(head:Node,n:Int) : Unit = {
    var temp = head
    var fast = temp
    var slow:Node = null
    var index = 0
    while(temp != null)
      {
          if(index == n)
            {
              slow = head
            }

          temp = temp.next
          if(slow != null)
             slow = slow.next
          index+=1
      }

    println(s"\n $n th node from end is : ${slow.data}")
  }

}
