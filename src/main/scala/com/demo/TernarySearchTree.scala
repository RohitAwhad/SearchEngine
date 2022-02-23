package com.demo

import java.util

class TernarySearchTree {

  private var root:Node = _

  def getValue(node: Node, key: String, index: Int): Node = {

    // base condition
    if(node ==null) return null

    //considering character of key 1 by 1
    val c:Char = key.charAt(index)
    if(c < node.character){getValue(node.get_leftchild(),key,index)}
    else if(c>node.character) {getValue(node.get_rightchild(),key,index)}
    else if (index < key.length-1) {getValue(node.get_middlechild(),key,index+1)}
    else{
      // we have considered all letters
      if(!node.get_leaf()) return null

      return node

    }
  }

  // associative array - we get filename based on key
  def get(key:String):Set[String] ={
      val node:Node = getValue(root,key,0)
   //Incase of search miss
    if(node==null) return null

     node.get_value()
  }

  def put(key:String, value:String) ={
    root = insert(root,key,value,0)
  }
  def insert( root: Node, key: String, value: String, index: Int): Node = {
    // character of key
    var node = root
    val c:Char = key.charAt(index)
    //if node is null
    if(node==null) {
      node = new Node(c)
    }

    //location of new node
    if(c < node.character){
      node.set_leftchild(insert(node.get_leftchild(),key,value,index))
    }
    else if(c>node.character){
      node.set_rightchild(insert(node.get_rightchild(),key,value,index))
    }
    else if(index < key.length-1){
      node.set_middlechild(insert(node.get_middlechild(),key,value,index+1))
    }   //this is leaf Node
    else{
      node.set_leaf(true)
      //assigning value to leaf node
      node.set_value(value)
    }
    node
  }

}
