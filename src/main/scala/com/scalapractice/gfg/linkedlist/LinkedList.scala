package com.scalapractice.gfg.linkedlist


class LinkedList() {
  var head: Node = null

  def push(data: Int): Unit = {
    val new_node = new Node(data)

    head == null match{
      case true => head = new_node
      case false => {
        var temp = head
        while (temp.next != null)
              temp = temp.next
        temp.next = new_node
      }
    }
  }

  def pop():Boolean = {
      head == null match {
       case true => false
       case _ => {
                  head = head.next
                  true
                  }
      }
  }

  def addInBeginning( value: Int): Node = {
    val newNode = new Node(value, null)
    newNode.next = head
    head = newNode
    newNode
  }
}

