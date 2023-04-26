package com.scalapractice.gfg.linkedlist

object LinkedListDemo {

  def main(args: Array[String]): Unit = {
    val one = Node(1,null)
    val two = Node(2,null)
    val three = Node(3,null)
    val four = Node(4,null)

    one.next = two
    two.next = three
    three.next = four

    traverse(one)
    addInLast(one,5)
    println("After adding 5 at last")
    traverse(one)

    println("After adding 6 at beginning")
    val newHead = addInBeginning(one,6)
    traverse(newHead)
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
}
