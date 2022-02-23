package com.demo

import java.util

class Node (var character:Char){

  //private var character:Char = _
  private var valueList:Set[String] = Set.empty[String]
  private var leftchild:Node = _
  private var rightchild:Node = _
  private var middlechild:Node = _
  private var leaf:Boolean = _


  def set_value(x: String){
    valueList+=x
  }
  def get_value(): Set[String] ={
    return valueList
  }

  def set_leftchild(x: Node){
    leftchild= x
  }
  def get_leftchild(): Node ={
    return leftchild
  }

  def set_rightchild(x: Node){
    rightchild= x
  }
  def get_rightchild(): Node ={
    return rightchild
  }

  def set_leaf(x: Boolean){
    leaf= x
  }
  def get_leaf(): Boolean ={
    return leaf
  }

  def set_middlechild(x: Node){
    middlechild= x
  }
  def get_middlechild(): Node ={
    return middlechild
  }

  override def toString = s"Node($character)"
}
