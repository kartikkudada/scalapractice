package com.scalapractice.gfg.linkedlist

/*
Program for Nth node from the end of a Linked List

Given a Linked List and a number N, write a function that
 returns the value at the Nth node from the end of the Linked List.
 */
object NthNodeFromEnd {

  def main(args: Array[String]): Unit = {
    val list = new LinkedList
    list.push(1)
    list.push(2)
    list.push(3)
    list.push(4)
    list.push(5)

    LinkedListDemo.traverse(list.head)

    findNthNodeFromEnd(list.head,2)
  }

  def findNthNodeFromEnd(head:Node,n:Int) : Unit = {
    var temp = head
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
