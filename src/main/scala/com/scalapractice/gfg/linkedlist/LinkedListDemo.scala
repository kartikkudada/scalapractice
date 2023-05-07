package com.scalapractice.gfg.linkedlist

import jdk.nashorn.internal.ir.BreakableNode

import scala.annotation.tailrec
import scala.util.control.Breaks.break

object LinkedListDemo {

  def main(args: Array[String]): Unit = {
    val one = Node(1,null)
    val two = Node(2,null)
    val three = Node(3,null)
    val four = Node(4,null)
    val five = Node(5,null)

    one.next = two
    two.next = three
    three.next = four

    traverse(one)
    addInLast(one,5)
    println("\n After adding 5 at last")
    traverse(one)

    println("\n After adding 10 at beginning")
    val newHead = addInBeginning(one,10)
    traverse(newHead)

    searchNode(newHead,3)
    println("search node[value = 10]  using recursive way ")
    searchNodeRec(newHead,10)

    findLength(newHead)
    findLengthRec(newHead,0)

   val firstNodeAfterReverse = reverse(newHead)
   println(s" fist node after reverse ${firstNodeAfterReverse.data}")
    traverse(firstNodeAfterReverse)
  }

  def traverse(head:Node): Unit = {
    var temp = head
    while(temp != null)
      {
         if(temp.next == null)
           print(s" ${temp.data} ")
         else
           print(s" ${temp.data} -> ")
        temp = temp.next
      }
  }

  def addInLast(head:Node,value:Int):Unit = {
    var temp = head
    while(temp.next != null)
      {
        temp = temp.next
      }
      val newNode = Node(value,null)

    temp.next = newNode
  }

  def addInBeginning(head:Node,value:Int) : Node = {
      val newNode = Node(value,null)
      newNode.next = head
     newNode
  }

  /*
   search integer in list
   */
  def searchNode(head: Node, value: Int): Unit = {
    println(s"\n Search in linkedList by integer ${value}")

    var temp = head
    var flag = false
    scala.util.control.Breaks.breakable(
      while (temp != null) {
        if (temp.data == value) {
          flag = true
          break
        }
        temp = temp.next
      }
    )

    flag match {
      case true => println(s"found ${temp.data}")
      case false => println(s"found NO ")
    }
  }

  /*
     search node using recursive way [tail recursion]
   */

  @tailrec
  def searchNodeRec(head: Node, value: Int): Unit = {
    if (head == null) {
      println(s"Not Found  ${value}")
    }
    else if (head.data == value) {
      println(s"Found  ${value}")
    }
    else
      searchNodeRec(head.next, value)
  }

  /*
    Finding linkedlist length : iterative method
   */
  def findLength(head:Node) : Unit = {
      var length = 0
      var temp = head
      while(temp != null)
        {
          length +=1
          temp = temp.next
        }
    println(s" Size of linkedlist ${length}")
  }

    /*
      Finding linkedlist length : recursive approach
     */

  @tailrec
  def findLengthRec(head: Node,acc:Int): Unit = {
     if(head != null)
       findLengthRec(head.next,acc+1)
     else
    println(s" Size of linkedlist using recursion : ${acc}")
  }

  /*
    Reverse linked list
   */
  def reverse(head:Node) : Node = {
      var pre:Node = null
      var temp = head
      var nextNode:Node = null

     while(temp != null)
       {
         nextNode = temp.next
         temp.next = pre

         pre = temp
         temp = nextNode
         //temp = temp.next
       }
    pre
  }



}
