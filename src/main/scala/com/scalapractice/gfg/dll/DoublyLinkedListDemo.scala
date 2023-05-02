package com.scalapractice.gfg.dll

import scala.annotation.tailrec

object DoublyLinkedListDemo {

  def main(args: Array[String]): Unit = {
    val one = new Node(null,1,null)
    val two = new Node(null,2,null)
    val three = new Node(null,3,null)
    val four = new Node(null,4,null)

    one.next = two
    two.pre = one

    two.next = three
    three.pre = two

    three.next = four
    four.pre = three

    display(one)
    displayRec(one)
  }

  def display(head:Node):Unit = {
      var temp = head
    while(temp != null)
      {
         if(temp.next == null)
        print(s"${temp.data} ")
         else
           print(s"${temp.data} =>")
        temp = temp.next
      }
  }

  @tailrec
  def displayRec(head:Node):Unit = {
      head == null match
      {
        case true => return
        case false => print(s"${head.data} => ")
          displayRec(head.next)
      }
  }
}
