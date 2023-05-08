package com.scalapractice.gfg.linkedlist

case class Node(var data:Int,var next:Node){
 def this(data:Int)
    {
      this(data,null)
    }
}
