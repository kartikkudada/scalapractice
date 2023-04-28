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
    four.next = five

    traverse(one)
    addInLast(one,5)
    println("After adding 5 at last")
    traverse(one)

    println("After adding 6 at beginning")
    val newHead = addInBeginning(one,6)
    traverse(newHead)

    searchNode(one,3)
    searchNodeRec(one,10)
  }

  def traverse(head:Node): Unit = {
    var temp = head
    while(temp != null)
      {
        print(s" ${temp.data} ")
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
    println(s"\n Searching by integer ")

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
      println("Not Found")
    }
    else if (head.data == value) {
      println(s"Found  ${value}")
    }
    else
      searchNodeRec(head.next, value)
  }
}
